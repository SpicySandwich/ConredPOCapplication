package com.product.KafkaProducer;

import com.product.Entity.Product;

public interface ProductProducerInt {
	
	void sendMessage(Product product) ;
	void sendMessageDTO(String productid);


}
