package com.kongapigateway.KongAPIgateway.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;

import com.kongapigateway.KongAPIgateway.Model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	private static final String GET_ALL_PRODUCLIST = "http://localhost:9001/product";
	private static final String POST_ADD_PRODUCT = "http://localhost:9001/product";
	private static final String PUT_UPDATE_PRODUCT= "http://localhost:9001/product";
	private static final String DELETE_PRODUCT = "http://localhost:9001/product/{purchase_item}";
	private static final String GET_PRODUCT_BYID = "http://localhost:9001/product/{purchase_item}";
	
  
	public void RestServiceProduct() {
		
		
	}
	
    
	
	 public List<Product> getInfo() {

	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);

	        ResponseEntity<List<Product>> result = restTemplate.
	                exchange(GET_ALL_PRODUCLIST , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Product>>() {});

	        List<Product> userList = new ArrayList<>();
	        userList.addAll(result.getBody());

	        return userList;
	    }
	 
	   public ResponseEntity<Product>  saveData(Product product) {
		 
		   return    restTemplate.postForEntity(POST_ADD_PRODUCT, product, Product.class);
	
     
	    }
	   

	   public void deleteData(Integer purchase_item) {
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Product product = new Product();
		   HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		   ResponseEntity<Product> responseEntity = restTemplate.exchange(DELETE_PRODUCT, HttpMethod.DELETE, requestEntity, Product.class, proMap);
          responseEntity.getBody();
		   
//		   Map<String, Integer> proMap = new HashMap<String, Integer>();
//		   proMap.put("purchase_item", purchase_item);
//	      restTemplate.delete(DELETE_PRODUCT,proMap);
	     

	    }
	   
	   public Product findbyid(Integer purchase_item) {
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   
		   return restTemplate.getForObject(GET_PRODUCT_BYID, Product.class,proMap);

		   
		
		   
	   }
	   
	   public void updateProductr(Product product) {
		  restTemplate.put(PUT_UPDATE_PRODUCT, product);
		   
	   }


}
