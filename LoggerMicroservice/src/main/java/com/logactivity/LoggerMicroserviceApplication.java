package com.logactivity;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages = "com.logactivity")
public class LoggerMicroserviceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LoggerMicroserviceApplication.class, args);
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	

}
