package com.cartgatewayservice;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
public class CartGatewayServiceApplication {
	

	

	public static void main(String[] args) {
		SpringApplication.run(CartGatewayServiceApplication.class, args);
		
	}
	
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
	    return new ProtobufHttpMessageConverter();
	}
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	


}
