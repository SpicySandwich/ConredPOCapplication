package com.product.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.product.Entity.Product;

@Repository
public class ProductDAOImpl  implements ProductDAO{
	
	
	@Autowired
	private EntityManager entityManager;


	@Override
	public List<Product> getProduct() {
	
		Session session = entityManager.unwrap(Session.class);
		Query<Product> query = session.createQuery("FROM Product", Product.class);
		List<Product>list = query.getResultList();
		session.close();
		return list;
		
	}

	@Override
	public Product getPoductInfo(Long productid) {
		
		Session session = entityManager.unwrap(Session.class);
	    Product productObj =	session.get(Product.class, productid);
	    session.close();
	    return productObj;
		
	}

	@Override
	public void save(Product product) {
		Session session = entityManager.unwrap(Session.class);
		    session.save(product);
		    session.close();
		
	}

	@Override
	public void delete(Long productid) {
		
		Session session = entityManager.unwrap(Session.class);
		Product productObj = session.get(Product.class, productid);
		session.delete(productObj);
		session.close();
		
	
		
	}

	@Override
	public  Object updateProduct(Product newProduct) {
		
		Session session = entityManager.unwrap(Session.class);
		session.update( newProduct);
		session.close();
		return newProduct;
	}

	


}
