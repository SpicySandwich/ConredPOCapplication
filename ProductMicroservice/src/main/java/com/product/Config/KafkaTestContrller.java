package com.product.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaTestContrller {
	
	 private final ProductDetailsProducer producer;
	


    public KafkaTestContrller(ProductDetailsProducer producer) {
		this.producer = producer;
	}



    @PostMapping("/publisher")
    public void  sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
        
    }

}
