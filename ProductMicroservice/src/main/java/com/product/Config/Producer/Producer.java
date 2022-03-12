package com.product.Config.Producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	   private static final String TOPIC= "producttopic";

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    public void writeMessage(String msg){

	        this.kafkaTemplate.send(TOPIC, msg);
	    }
	    
	    @Bean
	    public NewTopic adviceTopic(){

	    return new NewTopic ("TOPIC",3,(short) 1);
	    }

}
