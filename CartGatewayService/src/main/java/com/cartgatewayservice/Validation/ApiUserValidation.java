package com.cartgatewayservice.Validation;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cartgatewayservice.DTO.ProductDTO;
import com.cartgatewayservice.Model.ProductEntity;
import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.cartgatewayservice.RestModelException.NOT_NULL_EXCEPTION;


import org.springframework.stereotype.Service;

@Service
public class ApiUserValidation {
	
	
	
	public ProductDTO ProductnotNull(ProductDTO product) {
		

		
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
	
	public String DateFormatValidation(String dString ) {
	//	String dString =  DateNotNull(input);
		
		DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		 YearMonth yearMonth = YearMonth.parse(dString, localDateFormatter);
		 LocalDate dateCheckday = yearMonth.atEndOfMonth(); 
		 Integer checkDay =  dateCheckday.getDayOfMonth();
	 
		 String replacedate  = dString.replace("-", "");
		 
		    String dayIndex =replacedate.substring(6, 8);
		    Integer actualInputDay = Integer.parseInt(dayIndex);
		  if ( actualInputDay > checkDay || actualInputDay <= 0)  throw new DATE_FORMAT_EXCEPTION("Day cannot be greater than "+checkDay);
		  
		  String MonthIndex =replacedate.substring(4, 6);
		    Integer actualInputmonth = Integer.parseInt(MonthIndex );
		  if (actualInputmonth >= 13 )throw new DATE_FORMAT_EXCEPTION("Month cannot be greater than 12");
		  

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
