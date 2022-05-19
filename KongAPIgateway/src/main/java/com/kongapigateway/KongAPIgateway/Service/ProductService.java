package com.kongapigateway.KongAPIgateway.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;

import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductIDnotFound;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

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
public class ProductService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	private static final String GET_ALL_PRODUCLIST = "http://productmicroservice:8091/product";
	private static final String POST_ADD_PRODUCT = "http://productmicroservice:8091/product";
	private static final String PUT_UPDATE_PRODUCT= "http://productmicroservice:8091/product";
	private static final String DELETE_PRODUCT = "http://productmicroservice:8091/product/{purchase_item}";
	private static final String GET_PRODUCT_BYID = "http://productmicroservice:8091/product/{purchase_item}";
	
  

	
    
	
	 public List<Product> getInfo() {
	   try {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);
	

	        ResponseEntity<List<Product>> result = restTemplate.
	                exchange(GET_ALL_PRODUCLIST , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Product>>() {});
    
	  
	   List<Product> productList = new ArrayList<>();
       productList.addAll(result.getBody());

       return productList;
	
       } catch (Exception e) {
	
	       throw new ProductExecption("Product list is not available at the moment");

     }
	     
	    }
	 
	   public String  saveData(Product product) {
		   
		  try {
			  
			    restTemplate.postForEntity(POST_ADD_PRODUCT, product, Product.class);
			    return  "Succefully added the product " + product;
			
		} catch (Exception e) {
		
		throw new ProductValueNotNull("Kindly fill up all fields");
		}
		 
	    }
	   

	   public void deleteData(Integer purchase_item) {
	try {
		
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Product product = new Product();
		   HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		   ResponseEntity<Product> responseEntity = restTemplate.exchange(DELETE_PRODUCT, HttpMethod.DELETE, requestEntity, Product.class, proMap);
          responseEntity.getBody();
          
	}     catch (Exception e) {
		
		throw new ProductIDnotFound("Product id: " + purchase_item + " not found");
        		
      	}  

	    }
	   
	   public Product findbyid(Integer purchase_item) {
		   
		try {
		
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   
		   return restTemplate.getForObject(GET_PRODUCT_BYID, Product.class,proMap);
			
		} catch (Exception e) {
			
			throw new ProductIDnotFound("Product id: " + purchase_item + " not found");
			
		}
		
		    
	   }
	   
	   public void updateProductr(Product product) {
		   
		   try {
			   
			   restTemplate.put(PUT_UPDATE_PRODUCT, product);
			
		} catch (Exception e) {
			
			throw new ProductValueNotNull("Must not empty");
	
		}
		 
		   
	   }


}
