package com.cartgatewayservice.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("buy")
public class ProductController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String url= "http://localhost:8091/product/productlist";
	
	@GetMapping("/productavailable")
	public  List<Object> getProduct(){
		Object[] product = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(product);
		
	}

}
