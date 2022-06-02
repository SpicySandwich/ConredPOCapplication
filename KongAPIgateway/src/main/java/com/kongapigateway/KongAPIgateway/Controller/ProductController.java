package com.kongapigateway.KongAPIgateway.Controller;

import java.util.List;

import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getData(){
        return productService.getInfo();
    }

    @PostMapping("/add")
    public Product postData(@RequestBody Product product){
         productService.saveData(product);
         return product;
    }


    @DeleteMapping("/delete/{purchase_item}")
    public String deleteData(@PathVariable Integer purchase_item, @RequestBody Product product ){
        productService.deleteData(purchase_item);
   	 return "Successfully deleted ID: " + purchase_item;
    }

    @GetMapping("/find/{purchase_item}")
    public ResponseEntity<Product> findProduct(@PathVariable Integer purchase_item) {
    	
    	return	productService.findbyid(purchase_item);
    }
    
    
    @PutMapping("/update")
    public String  updateProduct(@RequestBody Product product){
         productService.updateProductr(product);
		return "Succesfully updated " + product;
    }
	


}
