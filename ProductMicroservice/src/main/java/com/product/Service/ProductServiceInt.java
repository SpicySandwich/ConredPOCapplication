package com.product.Service;

import java.util.List;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

public  interface ProductServiceInt {
	

	 
		List <Product> getProduct();

		Product getPoductInfo (Long productid);

		void save(Product product);

		void delete (Long id);
		
		Object updateProduct (ProductDTO newProduct);

}
