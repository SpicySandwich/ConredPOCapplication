package com.product.KafkaProducer;

import com.product.Entity.Product;
import com.product.ModelException.ProductInternalError;

public interface ProductProducerInt {
	
	void sendMessage(Product product) ;
	void sendMessageDTO(String productid);
	void sendMessageException(ProductInternalError productInternalError);


}
