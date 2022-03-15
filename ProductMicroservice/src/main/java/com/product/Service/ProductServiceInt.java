package com.product.Service;

import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

public  interface ProductServiceInt {
	
	
	Product  addProduct(Product  product);

	Product updateProduct (ProductDTO newProduct);
	
	 List<Product > showAll() ;
	 
	 void deletedataByID(Long  productid);
	 
	 Product getUserByUserId(Long productid);
	 


}
