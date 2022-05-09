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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class ApiService {
	
	private static final String GET_ALL_PRODUCLIST = "http://localhost:9001/product";
	private static final String POST_ADD_PRODUCT = "http://localhost:9001/product";
	private static final String PUT_UPDATE_PRODUCT= "http://localhost:9001/product";
	private static final String DELETE_PRODUCT = "http://localhost:9001/product";
	private static final String GET_PRODUCT_BYID = "http://localhost:9001/product/{purchase_item}";
	
	String url = "http://localhost:9001/product";
	
	@Autowired
    private static RestTemplate restTemplate;
	
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
	 
	   public Product saveData(Product requestUser) {

	        

	        ResponseEntity<Product> result = restTemplate.postForEntity(POST_ADD_PRODUCT, requestUser, Product.class);

	        
	        
//	        Product product = new Product();
//	        
//	        product.setPurchase_item(result.getBody().getPurchase_item());
//	        product.setProductname(result.getBody().getProductname());
//	        product.setProductbrand(result.getBody().getProductbrand());
//	        product.setProductprice(result.getBody().getProductprice());
//	        product.setProductdescription(result.getBody().getProductdescription());
//	        product.setProductquantity(result.getBody().getProductquantity());
//	        product.setProductexpirationdate(result.getBody().getProductexpirationdate());
	      

	        return result.getBody();
	    }
	   
//	   
	   public void deleteData(Integer purchase_item) {



	        try{
	            restTemplate.delete(DELETE_PRODUCT);
	        }catch (Exception e){
	            e.getMessage();
	        }
	    }
	   
	   public Product findbyid(Integer purchase_item) {
		   Map<String, Integer> proMap = new HashMap<>();
		   proMap.put("purchase_item", purchase_item);
		   
		   Product product = restTemplate.getForObject(GET_PRODUCT_BYID, Product.class,proMap);
		   
		   product.getPurchase_item();
		   product.getProductname();
		   product.getProductbrand();
		   product.getProductprice();
		   product.getProductdescription();
		   product.getProductquantity();
		   product.getProductexpirationdate();
		   
		return product;
		   
	   }


}
