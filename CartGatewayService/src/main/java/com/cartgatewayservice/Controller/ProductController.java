package com.cartgatewayservice.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartgatewayservice.Model.GuestClient;
import com.cartgatewayservice.Service.ProductService;
import com.grpcserver.product.ProductServer.Product;




@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//    @PostMapping("/add")
//    public String addClient( @RequestBody Product guestClient) {
////     return  grpcClientGuestService.inserdata(guestClient);
//    	
//    	return productService.inserdata(guestClient);
//        
//        
//    }
	
	
	




}
