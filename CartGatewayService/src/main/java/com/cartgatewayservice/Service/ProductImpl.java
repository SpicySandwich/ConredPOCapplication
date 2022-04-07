//package com.cartgatewayservice.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.cartgatewayservice.Model.ProductInt;
//import com.cartgatewayservice.Model.ProductToCart;
//import com.cartgatewayservice.RestURL.ProductRestURL;
//
//
//@Service
//public class ProductImpl implements ProductInt{
//
//	@Autowired
//	RestTemplate restTemplate;
//	
//	@Autowired
//	private ProductRestURL productRestURL;
//	
//
//	
//	
//	@Override
//	public ProductToCart getByID(Long productid) {
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		
//		
//		
//		HttpEntity<String> entity = new HttpEntity<String>( headers);
//		
//		ResponseEntity<ProductToCart> responseEntity = restTemplate.exchange(
//				productRestURL.getGET_PRODUCT_DETAILS()  
//				+ "/"+ productid,  HttpMethod.GET,entity,
//				ProductToCart.class );
//		
//	return responseEntity.getBody();
//	
//	}
//	
//	
//
//
//}
