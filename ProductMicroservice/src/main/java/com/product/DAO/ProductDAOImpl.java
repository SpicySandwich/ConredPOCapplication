package com.product.DAO;

import java.util.List;

import com.product.Entity.Product;

public interface ProductDAOImpl {
	
	List <Product> getProduct();

	Product get (long productid);

	void save(Product product);

	void delete (int id);

}
