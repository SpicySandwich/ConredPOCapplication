package com.cartgatewayservice.Deserializer;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime>{
	

	 
	  public LocalDateTimeDeserializer() {
	        super(LocalDateTime.class);
	    }

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		
		return LocalDateTime.parse(p.getValueAsString());

	}


}
