package com.cartservice.Validation;


import java.time.LocalDate;
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
		
		DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate local_date = LocalDate.parse(dateString, localDateFormatter);
		   
		  Date checkdate = Date.from(local_date .atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		LocalDate currentdate = LocalDate.now();

		LocalDate expiredDate =currentdate.plusMonths(2);
		int expiredday = expiredDate.getDayOfMonth();
		int expiredyear = expiredDate.getYear();
		int expiredmonth= expiredDate.getMonthValue();
		
		LocalDate localDate2 =LocalDate.of(expiredyear,expiredmonth,expiredday );
		Date checkdate2 = Date.from(localDate2 .atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		if(    checkdate .equals(checkdate2)  || 
				checkdate .before(checkdate2)) throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Date must a head for 2 month with ahead of current day: " + localDate2);

		return checkdate ;
   
	}
	
	public LocalDate DateMonthExceed(Integer year, Integer month, Integer day) {
	
		 String myString =  String.format("%d-%02d-%02d", DateNotNull(year), DateNotNull(month), DateNotNull(day));
		 
		 if (!myString.matches(
				 " ^((?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:(?:0[13578]|1[02])(-)31)|((0[1,3-9]|1[0-2])(-)(29|30))))$|^(?:(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(-)02(-)29)$|^(?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:0[1-9])|(?:1[0-2]))(-)(?:0[1-9]|1\\d|2[0-8])$")) 
			 throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Invalid Date format");
	   
				  return LocalDate.of(year, month, day);
			
	}
	
	
	public Integer DateNotNull(Integer integer) {
	if (integer == null || integer <= 0 )throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR,"Date cannot be empty");
	return integer;
	
}

	
	

	

}
