package com.product.Controller;

import java.util.List;
import java.util.stream.Collectors;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.Entity.ProductReviews;
import com.product.ModeException.ControllerException;
import com.product.Repository.ProductRepository;
import com.product.Repository.ReviewRepo;
import com.product.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class ProductController {

      @Autowired
      private ProductRepository productRepository;
      
      @Autowired
      private ProductService productService;
      
      @Autowired
  	KafkaTemplate<String, Product> kafkaTemplate ;
      
      @Autowired
    	KafkaTemplate<String, ProductDTO> kafkaTemplateDTO ;
  	
  	@Autowired
  	RestTemplate restTemplate;
  	
 
  	private final String producttopic = "producttopic";
      

  	 @GetMapping("/productlist")
     public List<Product> GetProductName(){
           return productService.showAll();
       
}
     
     @PostMapping("/addproduct")
     Product PostProduct(@RequestBody(required = true) Product product) {
   	 kafkaTemplate.send(producttopic, product);
       return productRepository.save(product);
     }
   
     @GetMapping("/productview/{productid}")
     public ProductDTO GetProductName(@PathVariable Long productid,@RequestBody(required = true) ProductDTO product){
   		 kafkaTemplateDTO.send(producttopic, product); 
   	  return productService.getUserByUserId(productid);
     }
     
     @PutMapping("/productupdate")
     public Product PutProduct(@RequestBody(required = true)  ProductDTO product){
   	  kafkaTemplateDTO.send(producttopic, product);
        return  productService.updateProduct(product);
     }

     @DeleteMapping("/productdelete/{productid}")
     public Long  DeteleProduct(@PathVariable Long productid,@RequestBody(required = true) ProductDTO product){
   	  kafkaTemplateDTO.send(producttopic, product);
   	  productService.deletedataByID(productid);
           return productid;


     }
      

}
