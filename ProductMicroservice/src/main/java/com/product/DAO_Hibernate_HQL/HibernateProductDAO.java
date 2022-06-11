package com.product.DAO_Hibernate_HQL;

import java.util.List;
import com.product.Entity.Product;



public interface HibernateProductDAO {
	
	
	List <Product> getProduct();

	Product getPoductInfo(Integer purchase_item);

	Product save(Product product);

	Product delete (Integer purchase_item);
	
	Object updateProduct (Product currentProduct);
	

	
	

}
