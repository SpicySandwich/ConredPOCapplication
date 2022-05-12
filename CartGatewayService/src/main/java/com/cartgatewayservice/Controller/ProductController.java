package com.cartgatewayservice.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.cartgatewayservice.Model.ProductEntity;
import com.cartgatewayservice.Service.ProductService;




@RestController
@RequestMapping(value = "/cart")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	 @GetMapping
     public List<ProductEntity> GetProductList( ){
		 
           return productService.list();
      
           
  	 }

    @PostMapping
    public ProductEntity addProduct( @RequestBody ProductEntity productEntity) {

    	productService.inserdata(productEntity);
    	return productEntity;
        
    }
    
    @DeleteMapping("/{purchase_item}")
    public void DeleteProduct(@PathVariable Integer purchase_item, @RequestBody ProductEntity productEntity) {
    	productService.deletedata(purchase_item);

   
   	 
    }
    
    @GetMapping("/{purchase_item}")
	 public ProductEntity  getGuestClientData(@PathVariable Integer purchase_item, @RequestBody ProductEntity productEntityt) {
    	
    	return productService.findbyid(purchase_item);
       
	 
}
    
    @PutMapping
    public void updateProduct(@RequestBody ProductEntity productEntity){
    	productService.updatedata(productEntity);
	
      
    }
	



}
