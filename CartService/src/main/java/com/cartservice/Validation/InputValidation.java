package com.cartservice.Validation;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cartservice.ConvertParameters.BodyConvertParametrs;
import com.cartservice.ModelExceptionGRPC.DATE_EXCEPTION_GRPC;
import com.cartservice.ModelExceptionGRPC.NOT_NULL_GRPC;
import com.grpcserver.product.ProductServer.CartErrorCode;
import com.grpcserver.product.ProductServer.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputValidation {
	
	
	@Autowired
	private BodyConvertParametrs bofBodyConvertParametrs;
	
	public  Product nullErrors( Product  request){
		
	    if (
	    		bofBodyConvertParametrs.convertJavaString(request.getProductname()).trim().isEmpty()
		    || bofBodyConvertParametrs.convertJavaString(request.getProductbrand()).trim().isEmpty()
		    || bofBodyConvertParametrs.convertJavaString( request.getProductdescription()).trim().isEmpty()
		    	) throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL,"Kindly fill up all field");
		return request;
	
	}
	public boolean isNullOrZeroDouble(Double i){
		
	     return i == null || i.doubleValue() == 0;
	}
	
	public boolean isNullOrZeroInterger(Integer i){
		boolean valid = true;
	   if (i == null || i.intValue() == 0) throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL,"Kindly fill up all field");

		return valid;

	}
	
	
	

	public Date DateFormatValidation(String dateString) {
		
		  if (!dateString.matches( "(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])"))  throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Date format is invalid. Example format (yyyy-MM-dd)");
		 
		return checkdateFuture(dateString);
				 
		  
	}
	
	
	
	public Date  checkdateFuture(String dateString) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate local_date = LocalDate.parse(dateString, localDateFormatter);
		  
		  Date checkdate = Date.from(local_date .atStartOfDay(defaultZoneId).toInstant());
		
		LocalDate currentdate = LocalDate.now();

		LocalDate expiredDate =currentdate.plusMonths(2);
		int expiredday = expiredDate.getDayOfMonth();
		int expiredyear = expiredDate.getYear();
		int expiredmonth= expiredDate.getMonthValue();
		
	
		LocalDate localDate2 =LocalDate.of(expiredyear,expiredmonth,expiredday );
		Date checkdate2 = Date.from(localDate2 .atStartOfDay(defaultZoneId).toInstant());
		
		if(    checkdate .equals(checkdate2)  || 
				checkdate .before(checkdate2)) throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Date must a head for 2 month with ahead of current day: " + localDate2);
		
		return checkdate ;
   
	}
	
	public Integer dateNotNull(Integer integer) {
		if (integer == null || integer == 0)throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Date cannot be empty");
		return integer;
		
		
	}
	

}
