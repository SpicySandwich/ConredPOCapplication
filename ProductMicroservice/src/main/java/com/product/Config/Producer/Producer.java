package com.product.Config.Producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	@Value("${topic.name}")   
	private String producttopic;

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    public void writeMessage(String msg){

	        this.kafkaTemplate.send(producttopic, msg);
	    }
	    
	    @Bean
	    public NewTopic addNewTopic() {
	    	
	    	return new NewTopic("producttopic",1,(short) 1);
	    }
	    
	    


}
