package com.product.Controller;

import java.util.Date;
import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.ModeException.ErrorDetail;
import com.product.ModeException.ProductExecption;
import com.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

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
     Product PostProduct(@RequestBody(required = true) Product product) {
 // 	 kafkaTemplate.send(TOPIC, product);
    //   return  productService.addProduct(product);
       
    	 productService.save(product);
		return product;
     }
//   
//     @GetMapping("/productview/{productid}")
//     public Product GetProductName(@PathVariable Long productid,@RequestBody(required = true) ProductDTO product){
//   		 kafkaTemplateDTO.send(TOPIC, product); 
//   	  return productService.getUserByUserId(productid);
//     }
//     
//     @PutMapping("/productupdate")
//     public Product PutProduct(@RequestBody(required = true)  ProductDTO product){
//   	  kafkaTemplateDTO.send(TOPIC, product);
//        return  productService.updateProduct(product);
//     }
//
//     @DeleteMapping("/productdelete/{productid}")
//     public Long  DeteleProduct(@PathVariable Long productid,@RequestBody(required = true) ProductDTO product){
//   	  kafkaTemplateDTO.send(TOPIC, product);
//   	  productService.deletedataByID(productid);
//           return productid;
//
//
//     }
     
 	



}
