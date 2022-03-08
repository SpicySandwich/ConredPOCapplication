package com.product.Service;

import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

public  interface ProductServiceInt {
	

	Product addProduct (ProductDTO newProduct);
	
	 List<Product > showAll() ;
	 
	 void deletedataByID(Long  productid);
	 
	 ProductDTO getUserByUserId(Long productid);
	 


}
