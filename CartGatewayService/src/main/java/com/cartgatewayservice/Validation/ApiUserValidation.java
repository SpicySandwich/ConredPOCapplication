package com.cartgatewayservice.Validation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cartgatewayservice.Model.ProductEntity;
import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.cartgatewayservice.RestModelException.NOT_NULL_EXCEPTION;


import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {
	
	public ProductEntity ProductnotNull(ProductEntity product) {
		

		
		if ( product.getProductname().trim().isEmpty()
			|| product.getProductbrand().trim().isEmpty()
			|| isNullOrZeroDouble( product.getProductprice() )
			||  product.getProductdescription().trim().isEmpty()
			|| isNullOrZeroInterger(product.getProductquantity() )
			
				) {
			
			throw new NOT_NULL_EXCEPTION("Please input all field");
			
		}
		
		return  product;
		
	}
	
	
	public boolean isNullOrZeroDouble(Double i){
	     return i == null || i.doubleValue() == 0;
	}
	
	public boolean isNullOrZeroInterger(Integer i){
	     return i == null || i.intValue() == 0;
	}
	
	
	public void DateValidationError(String string) {
		 
	    DateValidationError(string);
		
		}

	public String DateNotNull(String date) {
		  
		    if (date.trim().isEmpty() || date == null) throw new NOT_NULL_EXCEPTION("Date cannot be empty");
		    
		    return date;
		    
		}
	
	public String DateFormatValidation(String input) {
		String dString =  DateNotNull(input);
		  String DateFormatPattern = 
				  "([20]{2}[0-9]{2})"+
	  		    		"([-]{1})" +
	  		    		 "([0]{1}[1-9]{1}|[1]{1}[0-2]{1}|[1-9]{1})"+
	  		    		"([-]{1})" +
	  		    		"([1-9]{1}|[0]{1}[1-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-9]{1}|[3]{1}[0-1]{1})" ;
		  
		  Pattern pattern = Pattern.compile(DateFormatPattern);
		  Matcher matcher = pattern.matcher(dString);
		  
		  if (!matcher.matches())  throw new DATE_FORMAT_EXCEPTION("Date format is invalid. Example format (yyyy-MM-dd) ");
		return checkDateIfEqualOrPrevious(dString);
				 
		  
	}

		public String  checkDateIfEqualOrPrevious(String stringdate) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate datep = LocalDate.parse(stringdate, formatter);
			
			ZoneId defaultZoneId = ZoneId.systemDefault();
			
			Date date = Date.from(datep.atStartOfDay(defaultZoneId).toInstant());

		       LocalDate currentdate = LocalDate.now();
		       
		       LocalDate expiredDate =currentdate.plusMonths(2);
		       int expiredday = expiredDate.getDayOfMonth();
		       int expiredyear = expiredDate.getYear();
		       int expiredmonth= expiredDate.getMonthValue();

				
				LocalDate localDate2 =LocalDate.of(expiredyear,expiredmonth,expiredday );
				Date checkdate = Date.from(localDate2 .atStartOfDay(defaultZoneId).toInstant());
				
				LocalDate localDate3 =LocalDate.of(expiredyear,expiredmonth,expiredday + 1 );

				    date.getTime();
				    
				    if(date.equals(checkdate) || date.before(checkdate)) throw new DATE_FORMAT_EXCEPTION("Expiration date must ahead or equal to " + localDate3 + ".");
					return stringdate;
				 

		}

}
