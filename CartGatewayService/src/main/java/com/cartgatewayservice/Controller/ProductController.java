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

import com.cartgatewayservice.DTO.ProductDTO;
import com.cartgatewayservice.Model.ProductEntity;
import com.cartgatewayservice.Service.ProductService;




@RestController
@RequestMapping(value = "/cart")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	
	
	
	 @GetMapping
     public List<ProductDTO> GetProductList( ){
		 
           return productService.list();
      
           
  	 }

    @PostMapping
    public ProductDTO addProduct( @RequestBody ProductEntity productEntity) {
    	ProductDTO productDTO = productService.inserdata(productEntity);
    	return productDTO;
        
    }
    
    @DeleteMapping("/{purchase_item}")
    public void DeleteProduct(@PathVariable Integer purchase_item, @RequestBody ProductDTO productEntity) {
    	productService.deletedata(purchase_item);

   
   	 
    }
    
    @GetMapping("/{purchase_item}")
	 public ProductDTO  getProductData(@PathVariable Integer purchase_item) {
    	ProductDTO productDTO = productService.findbyid(purchase_item);
    	 return productDTO;
       
	 
}
    
    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductEntity productEntity){
    	ProductDTO productDTO = productService.updatedata(productEntity);
    	return productDTO;
	
      
    }
	

}
