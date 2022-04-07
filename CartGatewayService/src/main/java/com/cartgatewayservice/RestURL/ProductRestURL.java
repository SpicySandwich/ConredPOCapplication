package com.cartgatewayservice.RestURL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartgatewayservice.Model.ProductToCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Service
public class ProductRestURL {
	
	private RestTemplate restTemplate;
	
	private  String  GET_ALL_PRODUCT_LIST = "http://localhost:8091/product/productlist";
	
	private String  GET_PRODUCT_DETAILS = "http://localhost:8091/product/productview/{productid}";
	


	public ProductToCart getProductData(long productid) {
		
		Map<String, Long> responce = new HashMap<String, Long>();
		responce.put("productid", 25L);
		ProductToCart productToCart =  restTemplate.getForObject(GET_PRODUCT_DETAILS , ProductToCart.class, responce );
		  
		  return productToCart;
	}
	



}
