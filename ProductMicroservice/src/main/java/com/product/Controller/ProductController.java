package com.product.Controller;


import java.util.List;

import com.product.DAO.ProductDAOImpl;
import com.product.DTO.ProductDTO;
import com.product.Entity.ClientGuest;
import com.product.Entity.Product;
import com.product.Entity.TestDTO;
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
  	private ProductDAOImpl productDAOImpl;
  	
  	

  	 @GetMapping
     public List<ProductDTO> GetProductName(){
           return productService.getProduct();
           
  	 }
       
     @PostMapping
     public String PostProduct(@RequestBody Product product) {
    	 productService.save(product);
		return "Successfully added the Product: " + product;
     }
  
     @GetMapping("/{purchase_item}")
     public ProductDTO GetProductName(@PathVariable Integer purchase_item){
   	  return productService.getPoductInfo(purchase_item);
     }
    
     @PutMapping
     public String PutProduct(@RequestBody ProductDTO product){
        productService.updateProduct(product);
		return "Successfully update the product: " + product;
      
     }

     @DeleteMapping("/productdelete/{purchase_item}")
     public String DeteleProduct(@PathVariable Integer purchase_item,@RequestBody ProductDTO product){
   	  productService.delete(purchase_item);
           return "Succesfully deleted id:" +  purchase_item;


     }
     //test
     @PostMapping("/client")
     public void saveClient(@RequestBody TestDTO testDTO) {
    	 
    	//productDAOImpl.saveClient(clientGuest.getClientGuest());
    	 productService.create(testDTO.getClientGuest());
    	// productService.save(product);
    	 
     }
     
     @GetMapping("/client")
     public List<ClientGuest> findAllOrders(){
         return productDAOImpl.getClientGuestt();
     }
     
     @GetMapping("/client/{purchase_item}")
     public ClientGuest GetProductName2(@PathVariable Integer purchase_item){
   	  return productService.getById2(purchase_item);
     }
     
   



}
