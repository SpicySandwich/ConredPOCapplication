package com.kongapigateway.KongAPIgateway.Controller;

import java.util.List;

import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Service.ApiService;


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
@RequestMapping(value = "/kong")
public class KongController {
	
    @Autowired
    private ApiService apiService;

    @GetMapping
    public List<Product> getData(){
        return apiService.getInfo();
    }

    @PostMapping
    public ResponseEntity<Product> postData(@RequestBody Product product){
        return apiService.saveData(product);
        
    }


    @DeleteMapping("/{purchase_item}")
    public String deleteData(@PathVariable Integer purchase_item, @RequestBody Product product ){
        apiService.deleteData(purchase_item);
		return "Succesfully delete id: " + purchase_item;
    }

    @GetMapping("/{purchase_item}")
    public Product findProduct(@PathVariable Integer purchase_item) {
    	
    	return	apiService.findbyid(purchase_item);
    }
    
    
    @PutMapping
    public String  updateProduct(@RequestBody Product product){
         apiService.updateProductr(product);
		return "Succesfully updated " + product;
    }
	


}
