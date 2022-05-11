package com.kongapigateway.KongAPIgateway.Controller;

import java.util.List;

import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Service.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Product> getData(){
        return productService.getInfo();
    }

    @PostMapping
    public String postData(@RequestBody Product product){
        return productService.saveData(product);
        
    }


    @DeleteMapping("/{purchase_item}")
    public String deleteData(@PathVariable Integer purchase_item, @RequestBody Product product ){
        productService.deleteData(purchase_item);
		return "Succesfully delete id: " + purchase_item;
    }

    @GetMapping("/{purchase_item}")
    public Product findProduct(@PathVariable Integer purchase_item) {
    	
    	return	productService.findbyid(purchase_item);
    }
    
    
    @PutMapping
    public String  updateProduct(@RequestBody Product product){
         productService.updateProductr(product);
		return "Succesfully updated " + product;
    }
	


}
