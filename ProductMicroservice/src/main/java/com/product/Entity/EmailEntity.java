package com.product.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmailEntity {
	

	private String sender = "conredalasas12@gmail.com";
  
	private String receiver;
	
	private String subject = "POC Product";
	
	private String body;
	

}
