package com.kongapigateway.KongAPIgateway.DateDeserializer;

import java.io.IOException;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.kongapigateway.KongAPIgateway.ModelException.DATE_FORMAT_ERROR;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;




public class DateDeserializer extends  StdDeserializer<Date> {
	

	private static final long serialVersionUID = 1L;



	public  DateDeserializer() {
	    this(null); 
	} 
	protected DateDeserializer(Class<?> vc) {
		super(vc);

	}


	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException , JacksonException {
		
		DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	

		
        String dateValue = p.getValueAsString();
        
         LocalDate localDate = LocalDate.parse(DateFormatValidation(dateValue), localDateFormatter);
        	  
         return convertToDateViaInstant(localDate);
              

	
	}
	
	  public Date convertToDateViaInstant(LocalDate dateToConvert) {
	        return Date.from(dateToConvert.atStartOfDay()
	                .atZone(ZoneId.systemDefault())
	                .toInstant());
	    }
	  

	  

	  public void DateValidationError(String string) {
		 
	      DateValidationError(string);
		
		}
	  
	  public String DateNotNull(String date) {
		  
		    if (date.trim().isEmpty() || date == null) throw new ProductValueNotNull("Date cannot be empty");
		    
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
		  
		  if (!matcher.matches())  throw new DATE_FORMAT_ERROR("Date format is invalid. Example format (yyyy-MM-dd) ");
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
				    
				    if(date.equals(checkdate)) throw new ProductExecption("Expiration date must ahead or equal to " + localDate3 + ".");
				    if(date.before(checkdate)) throw new ProductExecption("Expiration date must ahead or equal to " + localDate3 + ".");
					return stringdate;
				 

		}
	  

}


