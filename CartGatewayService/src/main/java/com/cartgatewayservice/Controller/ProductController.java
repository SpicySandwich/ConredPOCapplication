package com.cartgatewayservice.Controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cartgatewayservice.Model.ProductToCart;
import com.cartgatewayservice.RestURL.ProductRestURL;



@RestController
@RequestMapping(value = "/buy")
public class ProductController {
	
	
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@Autowired
	private ProductRestURL productRestURL;
	
	
	@GetMapping("/productavailable")
	public  List<Object> getProduct(){
		Object[] product = restTemplate.getForObject(productRestURL.getGET_ALL_PRODUCT_LIST(), Object[].class);
		return Arrays.asList(product);
		
	}
	
	@GetMapping("/productview/{productid}")
	public ProductToCart getProductData(@PathVariable long productid) {
		
		Map<String, Long> responce = new HashMap<String, Long>();
		responce.put("productid",  productid);
		ProductToCart productToCart =  restTemplate.getForObject(productRestURL.getGET_PRODUCT_DETAILS(), ProductToCart.class, responce );
		  
		  return productToCart;
	}
	



}
