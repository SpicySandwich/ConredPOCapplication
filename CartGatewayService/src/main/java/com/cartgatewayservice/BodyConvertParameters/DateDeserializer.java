package com.cartgatewayservice.BodyConvertParameters;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import org.springframework.http.converter.HttpMessageNotReadableException;


public class DateDeserializer extends  StdDeserializer<Date> {
	

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
        

        try {
        	
        	  LocalDate localDate = LocalDate.parse(dateValue, localDateFormatter);
              return convertToDateViaInstant(localDate);
          
        } catch (DateTimeException e) {
        	
        	  throw new DateTimeException("Date format is invalid");
        }
	
	}
	
	  public Date convertToDateViaInstant(LocalDate dateToConvert) {
	        return Date.from(dateToConvert.atStartOfDay()
	                .atZone(ZoneId.systemDefault())
	                .toInstant());
	    }
	


}


