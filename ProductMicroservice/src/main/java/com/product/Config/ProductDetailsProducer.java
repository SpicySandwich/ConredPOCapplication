package com.product.Config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsProducer {
	
	  public static final Logger logger = LoggerFactory.getLogger(ProductDetailsProducer.class);
	    public static final String TOPIC = "producttopic";

	    @Autowired
	    KafkaTemplate<String,String> kafkaTemplate;

	    public ProductDetailsProducer() {
	        logger.info("Constructor::CustomerDetailsProducer");
	    }


	    public void sendMessage(String message) {
	        logger.info(String.format("#### -> Producing message -> %s", message));
	        this.kafkaTemplate.send(TOPIC, message);
	    }

}
