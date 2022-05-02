package com.cartservice;

import org.apache.ibatis.type.MappedTypes;
import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cartservice.Model.Client;
import com.cartservice.Model.ProductEntity;



@SpringBootApplication
@MappedTypes({Client.class,ProductEntity.class})
@MapperScan("com.cartservice.Repository")
public class CartServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
		
	
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	
	

}
