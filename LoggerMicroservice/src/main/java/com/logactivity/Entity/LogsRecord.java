package com.logactivity.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
@Document("log")
public class LogsRecord {
	
	@Id
	@Field(" records")
	private String records;
	
	
	

	
	

}
