package com.product.Controller;


import java.util.List;

import com.product.DAO_Hibernate_HQL.HibernateProductDAOImpl;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.KafkaProducer.ProductProducerKafkaTopic;
import com.product.Service.ProductService;
import com.product.ServiceEmail.EmailIml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
//@CrossOrigin
public class ProductController {
      
      @Autowired
      private ProductService productService;
     
  	
  	
  	@Autowired
  	private HibernateProductDAOImpl hibernateProductDAOImpl;
  	
  	@Autowired
  	private EmailIml email;
  	
  	

  	 @GetMapping
     public List<ProductDTO> GetProductName(){
           return productService.getProduct();
           
  	 }
       
     @PostMapping
     public ProductDTO  PostProduct(@RequestBody Product product) {
    	 ProductDTO  productdto = productService.save(product);
    	 email.sendEmail(productdto);
		return productdto;
		
     }
  
     @GetMapping("/{purchase_item}")
     public ProductDTO GetProductName(@PathVariable Integer purchase_item){
   	  return productService.getPoductInfo(purchase_item);
     }
    
     @PutMapping
     public void PutProduct(@RequestBody ProductDTO product){
        productService.updateProduct(product);
		
      
     }

     @DeleteMapping("/{purchase_item}")
     public void DeteleProduct(@PathVariable Integer purchase_item,@RequestBody ProductDTO product){
   	  productService.delete(purchase_item);
      


     }

     
   



}
