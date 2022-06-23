package com.kongapigateway.KongAPIgateway.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kongapigateway.KongAPIgateway.BodyParameter.BodyParameters;
import com.kongapigateway.KongAPIgateway.DTOModel.CartDTO;
import com.kongapigateway.KongAPIgateway.Model.Cart;
import com.kongapigateway.KongAPIgateway.ModelException.ProductIDnotFound;


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
	
	 public List<CartDTO> getInfo() {
   
			 
			    HttpHeaders headers = new HttpHeaders();
			    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			    HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);
			        ResponseEntity<List<Cart>> result = restTemplate.
			                exchange(GET_ALL_CARTLIST , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Cart>>() {});

			        return  bodyParameters.bodyCartDTOList(result.getBody());
			

	    }
	 
	   public CartDTO saveData(Cart cart) {
		   CartDTO cartDTO = bodyParameters.bodyCartDTOinsert(cart);
		   ResponseEntity<CartDTO>  result =  restTemplate.postForEntity(POST_ADD_CART, cartDTO, CartDTO.class);
			    return  result.getBody();
   
     
	    }
	   

	   public void  deleteData(Integer purchase_item) {

			  Map<String, Integer> proMap = new HashMap<String, Integer>();
			  proMap.put("purchase_item", purchase_item);
			   Cart cart = new Cart();
			   HttpEntity<CartDTO> requestEntity = new HttpEntity<CartDTO>(bodyParameters.bodyCartDTOdelete(cart));
			   
			  try {
			 restTemplate.exchange(DELETE_CART, HttpMethod.DELETE, requestEntity, CartDTO.class,proMap);
			} catch (Exception e) {
				throw new ProductIDnotFound( "ID: " +purchase_item + " not found");
			}
			   
	    }
	   
	   public CartDTO findbyid(Integer purchase_item) {
		   			  
			  Map<String, Integer> proMap = new HashMap<String, Integer>();
			   proMap.put("purchase_item", purchase_item);
			   Cart cart = new Cart();
			   HttpEntity<CartDTO> requestEntity = new HttpEntity<CartDTO>(bodyParameters.bodyCartDTOfindbyid(cart));
			   
			   try { 
				   ResponseEntity<CartDTO>  result = restTemplate.exchange(GET_CART_BYID, HttpMethod.GET, requestEntity, CartDTO.class, proMap);
				  return result.getBody(); 
			   } catch (Exception e) {
					throw new ProductIDnotFound( "ID: " +purchase_item + " not found");
				}
		

	   }
	   
	   public CartDTO updateProductr(Cart cart) {
		   
		   CartDTO cartDTO = bodyParameters.bodyCartDTOupdate(cart);
		   
		   try { 
			   restTemplate.put(PUT_UPDATE_CART,cartDTO);
				return cartDTO;
			} catch (Exception e) {
				throw new ProductIDnotFound( "ID: " + cartDTO.getPurchase_item()+ " is invalid for update or does not exist");
			}

		   
	   }

}
