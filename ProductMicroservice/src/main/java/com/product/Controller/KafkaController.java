package com.product.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.Config.Producer.Producer;

@RestController
public class KafkaController {
	
	
	private final Producer producer;

	    public KafkaController(com.product.Config.Producer.Producer producer) {
	        this.producer = producer;
	    }

	    @PostMapping("/publish")
	    public void writeMessageToTopic(@RequestParam("message") String message){
	        this.producer.sendMessage(message);

	    }

}
