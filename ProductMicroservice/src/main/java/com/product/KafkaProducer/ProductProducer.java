package com.product.KafkaProducer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.ModeException.ProductInternalError;

@Service
public class ProductProducer implements ProductProducerInt {
	
	 @Autowired
	    public KafkaTemplate<String, Product> KafkaTemplateProduct;
	 
	 @Autowired
	    public KafkaTemplate<String, String> KafkaTemplateProductDTO;
	 
	 @Autowired
	    public KafkaTemplate<String, ProductInternalError> KafkaTemplateProductExecption;
	 
	 @Autowired
	 public KafkaTemplate<String, ProductDTO> KafkaTemplateProductDTOupdate;
	 
	 private static final Logger Log = LoggerFactory.getLogger(ProductProducer.class);
	 
	 @Value("${topic.name}")
	 private  String TOPIC;
	
	   @SuppressWarnings({ "unchecked", "rawtypes" })
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
	   
	   @SuppressWarnings({ "unchecked", "rawtypes" })
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
	   
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	   @Override
	public void sendMessageException(ProductInternalError productInternalError) {
		
		   ListenableFuture<SendResult<String, ProductInternalError >> future = KafkaTemplateProductExecption.send(TOPIC, productInternalError);

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
	   
//	   @Bean
//		public NewTopic userTopic() {
//			return TopicBuilder.name(TOPIC)
//				      .partitions(1)
//				      .replicas(1)
//				      .build();
//		}



}
