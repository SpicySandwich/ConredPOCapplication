package com.product.DAO;

import java.util.List;
import com.product.Entity.Product;



public interface ProductDAO {
	
	
	List <Product> getProduct();

	Product getPoductInfo(Integer purchase_item);

	void save(Product product);

	Product delete (Integer purchase_item);
	
	Object updateProduct (Product currentProduct);
	

	
	

}
