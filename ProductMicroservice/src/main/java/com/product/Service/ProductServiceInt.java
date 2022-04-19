package com.product.Service;

import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

public  interface ProductServiceInt {
	

	 
		List <ProductDTO> getProduct();

		ProductDTO getPoductInfo (Integer purchase_item);

		ProductDTO save(Product product);

		ProductDTO delete (Integer purchase_item);
		
		Object updateProduct (ProductDTO newProduct);
		
	

}
