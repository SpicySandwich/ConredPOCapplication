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
	    private CartService cartService;

	    @GetMapping("/list")
	    public List<Cart> getData(){
	        return cartService.getInfo();
	    }

	    @PostMapping("/add")
	    public Cart postData(@RequestBody Cart cart){
	         cartService.saveData(cart);
	         return cart;
	        
	    }


	    @DeleteMapping("/delete/{purchase_item}")
	    public String deleteData(@PathVariable Integer purchase_item, @RequestBody Cart cart){
	    	cartService.deleteData(purchase_item);
			return "Succesfully delete id: " + purchase_item;
	    }

	    @GetMapping("/find/{purchase_item}")
	    public Cart findProduct(@PathVariable Integer purchase_item, @RequestBody Cart cart) {
	    	
	    		cartService.findbyid(purchase_item);
	    		return cart;
	    }
	    
	    
	    @PutMapping("/update")
	    public String  updateProduct(@RequestBody Cart cart){
	    	cartService.updateProductr(cart);
			return "Succesfully updated " + cart;
	    }

}
