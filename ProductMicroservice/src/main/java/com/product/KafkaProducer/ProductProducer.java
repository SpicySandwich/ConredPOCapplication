package com.product.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

@Service
public class ProductProducer implements ProductProducerInt {
	
	 @Autowired
	    public KafkaTemplate<String, Product> KafkaTemplateProduct;
	 
	 @Autowired
	    public KafkaTemplate<String, String> KafkaTemplateProductDTO;
	 

	 
	 @Autowired
	 public KafkaTemplate<String, ProductDTO> KafkaTemplateProductDTOupdate;
	 
	 private static final String TOPIC = "producttopic";
	
	   @SuppressWarnings("unchecked")
	   @Override
	public void sendMessage(Product product) {
	        ListenableFuture<SendResult<String,Product>> future = KafkaTemplateProduct.send(TOPIC , product);
	        future.addCallback(new ListenableFutureCallback() {
	        	
	            @Override
	            public void onFailure(Throwable ex) {
	                System.out.println("Messages failed to push on topic");
	            }

	            @Override
	            public void  onSuccess(Object result) {
	                System.out.println("Messages successfully pushed on topic");
	            }
	        });
	    }
	   
	   @SuppressWarnings("unchecked")
	   @Override
	public void sendMessageDTO(String productid) {
	        ListenableFuture<SendResult<String,String>> future = KafkaTemplateProductDTO.send(TOPIC , productid);
	        future.addCallback(new ListenableFutureCallback() {
	        	
	            @Override
	            public void onFailure(Throwable ex) {
	                System.out.println("Messages failed to push on topic");
	            }

	            @Override
	            public void onSuccess(Object result) {
	                System.out.println("Messages successfully pushed on topic");
	            }
	        });
	    }



}
