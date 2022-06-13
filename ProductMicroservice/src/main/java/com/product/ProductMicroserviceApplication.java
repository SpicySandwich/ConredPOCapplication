package com.product;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;




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
	
	
	
	
	

	


}
