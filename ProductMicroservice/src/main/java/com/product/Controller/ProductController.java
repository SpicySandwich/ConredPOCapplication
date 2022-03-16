package com.product.Controller;

import java.util.Date;
import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
//@CrossOrigin
public class ProductController {
      
      @Autowired
      private ProductService productService;
      
      @Autowired
  	KafkaTemplate<String, Product> kafkaTemplate ;
      
      @Autowired
    	KafkaTemplate<String, ProductDTO> kafkaTemplateDTO ;
  	
  	@Autowired
  	RestTemplate restTemplate;
  	

  	private  static final String TOPIC = "producttopic";
  	

  	 @GetMapping("/productlist")
     public List<Product> GetProductName(){
           return productService.getProduct();
           
  	 }
       
     @PostMapping("/addproduct")
     public String PostProduct(@RequestBody(required = true) Product product) {
	 kafkaTemplate.send(TOPIC, product);
  
       
    	 productService.save(product);
		return "Successfully added the Product: " + product;
     }
  
     @GetMapping("/productview/{productid}")
     public Product GetProductName(@PathVariable Long productid,@RequestBody(required = true) ProductDTO product){
  	 kafkaTemplateDTO.send(TOPIC, product); 
   	  return productService.getPoductInfo(productid);
     }
    
     @PutMapping("/productupdate")
     public String PutProduct(@RequestBody(required = true)  ProductDTO product){
	  kafkaTemplateDTO.send(TOPIC, product);
        productService.updateProduct(product);
		return "Successfully update the product: " + product;
       
     }

     @DeleteMapping("/productdelete/{productid}")
     public String DeteleProduct(@PathVariable Long productid,@RequestBody(required = true) ProductDTO product){
     kafkaTemplateDTO.send(TOPIC, product);
   	  productService.delete(productid);
           return "Succesfully deleted id:" +  productid;


     }
     
 	



}
