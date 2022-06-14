package com.product.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import com.product.Validation.ApiUserValidation;

import org.springframework.beans.factory.annotation.Autowired;





public class DateDeserializer extends  StdDeserializer<Date> {
	
	
	private static  ApiUserValidation apiUserValidation;
	
	
	@Autowired
    public void autowairedFixStatic(ApiUserValidation apiUserValidation){
		DateDeserializer.apiUserValidation= apiUserValidation;
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
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
        String dateValue = p.getValueAsString();
        
         LocalDate localDate = LocalDate.parse(apiUserValidation.DateFormatValidation(dateValue), localDateFormatter);
        
         Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
         
         return date;
             
	
	}



	  

}


