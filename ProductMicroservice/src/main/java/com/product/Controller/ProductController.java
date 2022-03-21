package com.product.Controller;


import java.util.List;
import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.KafkaProducer.ProductProducer;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
//@CrossOrigin
public class ProductController {
      
      @Autowired
      private ProductService productService;
     
  	@Autowired
  	RestTemplate restTemplate;
  	
  	

  	 @GetMapping("/productlist")
     public List<ProductDTO> GetProductName(){
           return productService.getProduct();
           
  	 }
       
     @PostMapping("/addproduct")
     public String PostProduct(@RequestBody Product product) {
    	 productService.save(product);
		return "Successfully added the Product: " + product;
     }
  
     @GetMapping("/productview/{productid}")
     public ProductDTO GetProductName(@PathVariable Long productid,@RequestBody  ProductDTO product){
   	  return productService.getPoductInfo(productid);
     }
    
     @PutMapping("/productupdate")
     public String PutProduct(@RequestBody ProductDTO product){
        productService.updateProduct(product);
		return "Successfully update the product: " + product;
       
     }

     @DeleteMapping("/productdelete/{productid}")
     public String DeteleProduct(@PathVariable Long productid,@RequestBody ProductDTO product){
   	  productService.delete(productid);
           return "Succesfully deleted id:" +  productid;


     }
     
 	



}
