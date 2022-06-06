package com.kongapigateway.KongAPIgateway.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kongapigateway.KongAPIgateway.BodyParameter.BodyParameters;
import com.kongapigateway.KongAPIgateway.DTOModel.ProductDTO;
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
	
	
	 public List<ProductDTO> getInfo() {
	   try {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    HttpEntity<String> httpEntity = new HttpEntity<>("parameters",headers);
	

	        ResponseEntity<List<Product>> result = restTemplate.
	                exchange(GET_ALL_PRODUCLIST , HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Product>>() {});
    

       return bodyParameters.bodyProductDTOList(result.getBody());
	
       } catch (Exception e) {
	
	       throw new ProductExecption("Product list is not available at the moment");

     }
	     
	    }
	 
	   public ProductDTO saveData(Product product) {
		   
		   ProductDTO productDTO =   bodyParameters.bodyProductDTOinsert(product);
			    restTemplate.postForEntity(POST_ADD_PRODUCT, product, ProductDTO.class);
			    return   productDTO;		

	    }
	   
	   public Object deleteData(Integer purchase_item) {

		
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Product product = new Product();
		   HttpEntity<ProductDTO> requestEntity = new HttpEntity<ProductDTO>(bodyParameters.bodyProductDTOdelete(product));
		   
		   try {
		   return restTemplate.exchange(DELETE_PRODUCT, HttpMethod.DELETE, requestEntity, ProductDTO.class, proMap);
		   } catch (Exception e) {
				throw new ProductIDnotFound( "ID: " +purchase_item + " not found");
			}

	    }
	   
	   public ResponseEntity<ProductDTO> findbyid(Integer purchase_item) {
		   
	
		   Map<String, Integer> proMap = new HashMap<String, Integer>();
		   proMap.put("purchase_item", purchase_item);
		   Product product = new Product();
		   HttpEntity<ProductDTO> requestEntity = new HttpEntity<ProductDTO>(bodyParameters.bodyProductDTOfindbyid(product));
		   
		   try { 
		  return restTemplate.exchange(GET_PRODUCT_BYID, HttpMethod.GET, requestEntity, ProductDTO.class, proMap);
			} catch (Exception e) {
				throw new ProductIDnotFound( "ID: " +purchase_item + " not found");
			}
		
		    
	   }
	   
	   public ProductDTO updateProductr(Product product) {
		   
		   ProductDTO productDTO = bodyParameters.bodyProductDTOupdate(product);
   
		   try {   
		   restTemplate.put(PUT_UPDATE_PRODUCT, productDTO);
			return productDTO;
		   } catch (Exception e) {
				throw new ProductIDnotFound( "ID: " +productDTO.getPurchase_item()+ " is invalid for update or does not exist");
			}
	
	
		 
		   
	   }


}
