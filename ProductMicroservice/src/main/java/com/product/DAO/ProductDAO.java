package com.product.DAO;

import java.util.List;
import com.product.Entity.Product;



public interface ProductDAO {
	
	
	List <Product> getProduct();

	Product getPoductInfo(long productid);

	void save(Product product);

	void delete (long id);
	
	Object updateProduct (Product currentProduct);
	

	
	

}
