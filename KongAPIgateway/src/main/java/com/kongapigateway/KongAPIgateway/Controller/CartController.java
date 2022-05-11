package com.kongapigateway.KongAPIgateway.Controller;

import java.util.List;

import com.kongapigateway.KongAPIgateway.Model.Cart;

import com.kongapigateway.KongAPIgateway.Service.CartService;


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
@RequestMapping(value = "/cart")
public class CartController {
	
	 @Autowired
	    private CartService productService;

	    @GetMapping
	    public List<Cart> getData(){
	        return productService.getInfo();
	    }

	    @PostMapping
	    public String postData(@RequestBody Cart cart){
	        return productService.saveData(cart);
	        
	    }


	    @DeleteMapping("/{purchase_item}")
	    public String deleteData(@PathVariable Integer purchase_item, @RequestBody Cart cart){
	        productService.deleteData(purchase_item);
			return "Succesfully delete id: " + purchase_item;
	    }

	    @GetMapping("/{purchase_item}")
	    public Cart findProduct(@PathVariable Integer purchase_item) {
	    	
	    	return	productService.findbyid(purchase_item);
	    }
	    
	    
	    @PutMapping
	    public String  updateProduct(@RequestBody Cart cart){
	         productService.updateProductr(cart);
			return "Succesfully updated " + cart;
	    }

}
