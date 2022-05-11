package com.kongapigateway.KongAPIgateway.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kongapigateway.KongAPIgateway.Model.Cart;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {
	

	RestTemplate restTemplate = new RestTemplate();
	
	private static final String GET_ALL_CARTLIST = "http://localhost:9009/product";
	private static final String POST_ADD_CART = "http://localhost:9009/product";
	private static final String PUT_UPDATE_CART= "http://localhost:9009/product";
	private static final String DELETE_CART= "http://localhost:9009/product/{purchase_item}";
	private static final String GET_CART_BYID = "http://localhost:9009/product/{purchase_item}";
	
  
	public void RestServiceProduct() {
		
		
	}
	
    
	
	 public List<Cart> getInfo() {

	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);

	        ResponseEntity<List<Cart>> result = restTemplate.
	                exchange(GET_ALL_CARTLIST , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Cart>>() {});

	        List<Cart> cartList = new ArrayList<>();
	        cartList .addAll(result.getBody());

	        return cartList ;
	    }
	 
	   public String  saveData(Cart cart) {
		 
		    restTemplate.postForEntity(POST_ADD_CART, cart, Cart.class);
		    return  "Succefully added the product " + cart;
     
	    }
	   

	   public void deleteData(Integer purchase_item) {
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Cart cart = new Cart();
		   HttpEntity<Cart> requestEntity = new HttpEntity<Cart>(cart);
		   ResponseEntity<Cart> responseEntity = restTemplate.exchange(DELETE_CART, HttpMethod.DELETE, requestEntity, Cart.class, proMap);
          responseEntity.getBody();
		   

	    }
	   
	   public Cart findbyid(Integer purchase_item) {
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   
		   return restTemplate.getForObject(GET_CART_BYID, Cart.class,proMap);
	
		   
	   }
	   
	   public void updateProductr(Cart cart) {
		  restTemplate.put(PUT_UPDATE_CART,cart);
		   
	   }

}
