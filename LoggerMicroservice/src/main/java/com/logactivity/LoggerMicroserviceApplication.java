package com.logactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LoggerMicroserviceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LoggerMicroserviceApplication.class, args);
		
	}

}
