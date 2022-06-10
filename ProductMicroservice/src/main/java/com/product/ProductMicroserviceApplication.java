package com.product;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;



@SpringBootApplication
@ComponentScan(basePackages = "com.product")
public class ProductMicroserviceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ProductMicroserviceApplication.class, args);

	
	} 
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
//	@Bean
//	public Jackson2ObjectMapperBuilder objectMapper() {
//	  return Jackson2ObjectMapperBuilder
//	        .json()
//	        .featuresToDisable(DeserializationFeature.WRAP_EXCEPTIONS)
//	        .build();
//	}
	
//	@Bean 
//	public Jackson2ObjectMapperBuilder objectMapperBuilder(){
//
//	    return Jackson2ObjectMapperBuilder.json().featuresToDisable(DeserializationFeature.WRAP_EXCEPTIONS) ;
//	}
	@Bean 
	public Jackson2ObjectMapperBuilder objectMapperBuilder(){
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    Jackson2ObjectMapperBuilder.json().featuresToDisable(DeserializationFeature.WRAP_EXCEPTIONS);
	    return builder;
	}
	
	

	


}
