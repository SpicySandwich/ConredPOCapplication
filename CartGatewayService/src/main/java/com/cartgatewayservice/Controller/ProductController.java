package com.cartgatewayservice.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	

	
//	@GetMapping("/productview/{productid}")
//	public ProductToCart getProductData (@PathVariable Long productid){
//		
//		return productRestURL.getProductData(productid);
//		
//	}
	
//	@GetMapping("/productview/{productid}")
//	@ResponseBody
//	public Object getEmployee(@PathVariable("productid") Long productid) {
//		return productRestURL.getProduct(productid);
//	}
	
	
//		@GetMapping("/productview/{productid}")
//	public  Object   getProductData(@PathVariable(" productid") Long productid, @RequestBody ProductToCart object2) {
//		
//		 HttpEntity<ProductToCart> request = new HttpEntity<>(object2);
//		 return  restTemplate.exchange(productRestURL.getGET_PRODUCT_DETAILS() + productid, HttpMethod.GET, request,
//	        		ProductToCart.class);
//	
//	}

	
//	@GetMapping("/productview/{productid}")
//	    public ResponseEntity<Map> deleteProduct(@PathVariable("productid") Long productid) {
//
//	        ResponseEntity<Map> response = restTemplate.exchange((productRestURL.getGET_PRODUCT_DETAILS()+ productid), HttpMethod.GET,
//	                HttpEntity.EMPTY, Map.class);
//	        return response;
//	    }
//	
//	 public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
//
//	        HttpEntity<Product> request = new HttpEntity<>(product);
//	        ResponseEntity<Product> response = restTemplate.exchange(SERVICE_ONE_URL, HttpMethod.PUT, request,
//	                Product.class);
//	        return response;
//	    }
	 
	 
	
//	@GetMapping("/productview/{productid}")
//	@ResponseBody
//	public Object getEmployee(@PathVariable("productid") Long productid) {
//		
//		Map<String, Long> responce = new HashMap<String, Long>();
//		responce.put("productid", productid);
//		
//		Object[] productToCart =  this.restTemplate.getForObject(productRestURL.getGET_PRODUCT_DETAILS() ,
//				Object[].class,  responce);
//		
//		return productToCart;
//	
//	}
		
	//	return productRestURL.getproduct(productid);

	
//	public Object getproduct(Long productid) {
//		return this.restTemplate.getForObject("http://localhost:8091/product/productview/" + productid,
//				Object.class);
//	}


}
