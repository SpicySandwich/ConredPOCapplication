package com.product.JsonDeserializer;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.product.DAO_Hibernate_HQL.HibernateUtilModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfiguration {
	
	private static HibernateUtilModel hibernateUtilModel;
	
	@Autowired
	public void fixautowired(HibernateUtilModel hibernateUtilModel) {
		ObjectMapperConfiguration.hibernateUtilModel=hibernateUtilModel;
	}
	
	 @Bean
	    public ObjectMapper objectMapper() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        final SimpleModule module = new SimpleModule();
	        module.addDeserializer(Date.class, new DateDeserializer());
	        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
	        objectMapper.registerModule(module);
	        objectMapper.configure(DeserializationFeature.WRAP_EXCEPTIONS,hibernateUtilModel.isWrapexceptions());
	        objectMapper.configure(SerializationFeature.WRAP_EXCEPTIONS,hibernateUtilModel.isWrapexceptions());

	        return objectMapper;
	    }
	 
	 @Bean
	    public ObjectMapper objectMapper2() {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(DeserializationFeature.WRAP_EXCEPTIONS,hibernateUtilModel.isWrapexceptions());
	        mapper.configure(SerializationFeature.WRAP_EXCEPTIONS,hibernateUtilModel.isWrapexceptions());

	        return mapper;
	    }
	 
	 
	 
	 

}
