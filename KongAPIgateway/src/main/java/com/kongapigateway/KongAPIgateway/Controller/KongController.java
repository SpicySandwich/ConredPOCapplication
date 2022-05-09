package com.kongapigateway.KongAPIgateway.Controller;

import java.util.List;

import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.Service.ApiService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Product postData(@RequestBody Product user){
        return apiService.saveData(user);
    }


    @DeleteMapping("/{purchase_item}")
    public void deleteData(@PathVariable Integer purchase_item){
        apiService.deleteData(purchase_item);
    }

    @GetMapping("/{purchase_item}")
    public Product findProduct(@PathVariable Integer purchase_item) {
    	
    	return	apiService.findbyid(purchase_item);
    }
	


}
