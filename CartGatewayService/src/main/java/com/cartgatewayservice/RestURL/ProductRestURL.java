package com.cartgatewayservice.RestURL;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductRestURL {
	
	private RestTemplate restTemplate;
	
	private  String  GET_ALL_PRODUCT_LIST = "http://localhost:8091/product/productlist";
	
	private String  GET_PRODUCT_DETAILS = "http://localhost:8091/product/productview/{productid}";
	

}
