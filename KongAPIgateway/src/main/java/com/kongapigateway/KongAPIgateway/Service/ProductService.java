package com.kongapigateway.KongAPIgateway.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kongapigateway.KongAPIgateway.BodyParameter.BodyParameters;
import com.kongapigateway.KongAPIgateway.Model.Product;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
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
public class ProductService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	private static final String GET_ALL_PRODUCLIST = "http://productmicroservice:8091/product";
	private static final String POST_ADD_PRODUCT = "http://productmicroservice:8091/product";
	private static final String PUT_UPDATE_PRODUCT= "http://productmicroservice:8091/product";
	private static final String DELETE_PRODUCT = "http://productmicroservice:8091/product/{purchase_item}";
	private static final String GET_PRODUCT_BYID = "http://productmicroservice:8091/product/{purchase_item}";
	
	@Autowired
	private BodyParameters bodyParameters;
	
	
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
	 
	   public Product saveData(Product product) {
		   
		   bodyParameters.bodyProduct(product);
			    restTemplate.postForEntity(POST_ADD_PRODUCT, product, Product.class);
			    return   product;		

	    }
	   
	   public Object deleteData(Integer purchase_item) {

		
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Product product = new Product();
		   HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		   
		   try {
		   return restTemplate.exchange(DELETE_PRODUCT, HttpMethod.DELETE, requestEntity, Product.class, proMap);
		   } catch (Exception e) {
				throw new ProductIDnotFound( "ID: " +purchase_item + " not found");
			}

	    }
	   
	   public ResponseEntity<Product> findbyid(Integer purchase_item) {
		   
	
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Product product = new Product();
		   HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		   
		   try { 
		  return restTemplate.exchange(GET_PRODUCT_BYID, HttpMethod.GET, requestEntity, Product.class, proMap);
			} catch (Exception e) {
				throw new ProductIDnotFound( "ID: " +purchase_item + " not found");
			}
		
		    
	   }
	   
	   public void updateProductr(Product product) {
   
		   try {   
		   restTemplate.put(PUT_UPDATE_PRODUCT, product);
		   } catch (Exception e) {
				throw new ProductIDnotFound( "ID: " + product.getPurchase_item()+ " is invalid for update or does not exist");
			}
	
		 
		   
	   }


}
