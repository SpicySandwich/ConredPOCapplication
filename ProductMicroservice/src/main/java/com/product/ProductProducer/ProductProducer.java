package com.product.ProductProducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
	
	private static final String TOPIC = "producttopic";
	
	
	  
	
	@Bean
	    public NewTopic createTopic(){

	        return new NewTopic(TOPIC,1,(short) 1);
	    }

}
