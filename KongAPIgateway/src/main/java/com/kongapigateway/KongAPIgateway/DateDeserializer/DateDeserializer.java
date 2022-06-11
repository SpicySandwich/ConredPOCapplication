package com.kongapigateway.KongAPIgateway.DateDeserializer;

import java.io.IOException;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.kongapigateway.KongAPIgateway.Validation.ApiUserValidation;

import org.springframework.beans.factory.annotation.Autowired;




public class DateDeserializer extends  StdDeserializer<Date> {
	

	private static final long serialVersionUID = 1L;
	
	private static ApiUserValidation apiUserValidation;
	
	@Autowired
	public void autowairedFixStatic(ApiUserValidation apiUserValidation) {
		DateDeserializer.apiUserValidation = apiUserValidation;
	}


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
        
         LocalDate localDate = LocalDate.parse(apiUserValidation.DateFormatValidation(dateValue), localDateFormatter);
        	  
         return convertToDateViaInstant(localDate);
              

	
	}
	
	  public Date convertToDateViaInstant(LocalDate dateToConvert) {
	        return Date.from(dateToConvert.atStartOfDay()
	                .atZone(ZoneId.systemDefault())
	                .toInstant());
	    }
	  

	  


}


