package com.product.Service;

import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

public  interface ProductServiceInt {
	

	 
		List <ProductDTO> getProduct();

		ProductDTO getPoductInfo (Long productid);

		ProductDTO save(Product product);

		ProductDTO delete (Long id);
		
		Object updateProduct (ProductDTO newProduct);
		
	

}
