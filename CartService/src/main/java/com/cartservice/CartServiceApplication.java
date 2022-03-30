package com.cartservice;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cartservice.Model.Client;



@SpringBootApplication
@MappedTypes(Client.class)
@MapperScan("com.cartservice.DAO")
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
		
	
	}
	
	

}
