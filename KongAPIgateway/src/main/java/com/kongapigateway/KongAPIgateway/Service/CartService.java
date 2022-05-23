package com.kongapigateway.KongAPIgateway.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kongapigateway.KongAPIgateway.BodyParameter.BodyParameters;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductIDnotFound;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private static final String GET_ALL_CARTLIST = "http://cartgatewayservice:8094/cart";
	private static final String POST_ADD_CART = "http://cartgatewayservice:8094/cart";
	private static final String PUT_UPDATE_CART= "http://cartgatewayservice:8094/cart";
	private static final String DELETE_CART= "http://cartgatewayservice:8094/cart/{purchase_item}";
	private static final String GET_CART_BYID = "http://cartgatewayservice:8094/cart/{purchase_item}";
	
	
	@Autowired
	private BodyParameters bodyParameters;
	
	 public List<Cart> getInfo() {
   
		 try {
			 
			    HttpHeaders headers = new HttpHeaders();
			    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			    
			    HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);

			        ResponseEntity<List<Cart>> result = restTemplate.
			                exchange(GET_ALL_CARTLIST , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Cart>>() {});

			        List<Cart> cartList = new ArrayList<>();
			        cartList .addAll(result.getBody());

			        return cartList ;
			
		} catch (Exception e) {
			   throw new ProductExecption("Cart list is not available at the moment");
		}

	    }
	 
	   public Cart saveData(Cart cart) {
		   bodyParameters.bodyCart(cart);
			   restTemplate.postForEntity(POST_ADD_CART, cart, Cart.class);
			   
			    return   cart;
   
     
	    }
	   

	   public void deleteData(Integer purchase_item) {
		   
		 try {
			 
			  Map<String, Integer> proMap = new HashMap<String, Integer>();
			   proMap.put("purchase_item", purchase_item);
			   Cart cart = new Cart();
			   HttpEntity<Cart> requestEntity = new HttpEntity<Cart>(cart);
			   ResponseEntity<Cart> responseEntity = restTemplate.exchange(DELETE_CART, HttpMethod.DELETE, requestEntity, Cart.class, proMap);
	          responseEntity.getBody();
			
		} catch (Exception e) {
			throw new ProductIDnotFound("Product id: " + purchase_item + " not found");
		}
		 
		   

	    }
	   
	   public Cart findbyid(Integer purchase_item) {
		   
		  try {
			  
			  Map<String, Integer> proMap = new HashMap<String, Integer>();
			   proMap.put("purchase_item", purchase_item);
			   Cart cart = new Cart();
			   HttpEntity<Cart> requestEntity = new HttpEntity<Cart>(cart);
			  ResponseEntity<Cart> responseEntity2 = restTemplate.exchange(GET_CART_BYID, HttpMethod.DELETE, requestEntity, Cart.class, proMap);
		          
			  Cart cart2 = responseEntity2.getBody();
			  
			  return cart2;
			
		} catch (Exception e) {
			throw new ProductIDnotFound("Product id: " + purchase_item + " not found");
			
		}
		   
	   }
	   
	   public void updateProductr(Cart cart) {
		   
		   try {
			   
			   restTemplate.put(PUT_UPDATE_CART,cart);
			
		} catch (Exception e) {
			throw new ProductValueNotNull("Must not empty");
		}
		
		   
	   }

}
