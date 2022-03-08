package com.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.product.Entity.ProductReviews;

import com.product.Repository.ReviewRepo;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {
	
  	
	 
  	private final String producttopic = "producttopic";
 
  	
  	@Autowired
  	RestTemplate restTemplate;
  	
  	@Autowired
    private ReviewRepo repo;
	
    @Autowired
	KafkaTemplate<String, ProductReviews> kafkaTemplateReviews ;
 

	  
    @PostMapping
    ProductReviews Postreviews(@RequestBody(required = true)   ProductReviews  reviews) {
    	kafkaTemplateReviews.send(producttopic, reviews);
      return repo.save(reviews);
    }
	
	
	
	

}
