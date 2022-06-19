package com.cartservice.Validation;


import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.cartservice.ModelExceptionGRPC.DATE_EXCEPTION_GRPC;
import com.cartservice.ModelExceptionGRPC.NOT_NULL_GRPC;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import com.grpcserver.product.ProductServer.CartErrorCode;
import org.springframework.stereotype.Service;

@Service
public class InputValidation {
	

	public boolean isNullString(StringValue stringValue){
		boolean valid = true;
	     if (stringValue.getValue().trim().isEmpty()) throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL,"Kindly fill up all field");
	     
	 	return valid;
	}
	
	
	public boolean isNullOrZeroDouble(DoubleValue doubleValue){
		boolean valid = true;
	     if (doubleValue== null ||doubleValue.getValue() == 0) throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL,"Kindly fill up all field");
	     
	 	return valid;
	}
	
	public boolean isNullOrZeroInterger(Int32Value int32Value){
		boolean valid = true;
	   if (int32Value == null || int32Value.getValue() == 0) throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL,"Kindly fill up all field");

		return valid;

	}

	
	public Date  checkdateFuture(String dateString){
		ZoneId defaultZoneId = ZoneId.systemDefault();
		DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		---------	
		 YearMonth yearMonth = YearMonth.parse(dateString, localDateFormatter);
		 LocalDate dateCheckday = yearMonth.atEndOfMonth(); 
		 Integer checkDay =  dateCheckday.getDayOfMonth();
	//		---------	 
		  LocalDate local_date = LocalDate.parse(dateString, localDateFormatter);
		  
		Integer daysinput  =local_date.getDayOfMonth();
		if ( daysinput > checkDay) {throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Day cant exceed to "+ checkDay);}
		
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
	
	public Integer DateNotNull(Integer integer) {
		if (integer == null || integer <= 0 )throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Date cannot be empty");
		return integer;
		
	}
	public Integer DateMonthExceed(Integer integer) {
		
		if(integer >=13)throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Month cant exceed at 12");
		return DateNotNull(integer);
			
	}
	

	

}
