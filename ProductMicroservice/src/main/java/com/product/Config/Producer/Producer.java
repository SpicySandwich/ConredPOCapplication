package com.product.Config.Producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class Producer {
	

	
	@Value ("${spring.kafka.template.default-topic}")
	private  String TOPIC;

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

//	    public void writeMessage(String msg){
//
//	        this.kafkaTemplate.send(TOPIC , msg);
//	    }
	    
	    public void sendMessage(String message) {
            
	        ListenableFuture<SendResult<String, String>> future = 
	        		 this.kafkaTemplate.send( TOPIC, message);
	    	
	        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	            @Override
	            public void onSuccess(SendResult<String, String> result) {
	                System.out.println("Sent message=[" + message + 
	                  "] with offset=[" + result.getRecordMetadata().offset() + "]");
	            }
	            @Override
	            public void onFailure(Throwable ex) {
	                System.out.println("Unable to send message=[" 
	                  + message + "] due to : " + ex.getMessage());
	            }
	        });
	    }
	    
	    


}
