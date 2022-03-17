package com.product.DAO;

import java.util.List;
import com.product.Entity.Product;



public interface ProductDAO {
	
	
	List <Product> getProduct();

	Product getPoductInfo(Long productid);

	void save(Product product);

	void delete (Long id);
	
	Object updateProduct (Product currentProduct);
	

	
	

}
