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
	public Product getPoductInfo(Integer purchase_item) {
		
		Session session = entityManager.unwrap(Session.class);
	    Product productObj =	session.get(Product.class, purchase_item);
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
	public Product delete(Integer purchase_item) {
		
		Session session = entityManager.unwrap(Session.class);	
		String hql = "DELETE FROM Product "  + 
	             "WHERE purchase_item = :purchase_item";
		Product productObj = session.get(Product.class, purchase_item);
	Query query = session.createQuery(hql);
	query.setParameter("purchase_item",purchase_item);
	query.executeUpdate();

	return productObj ;
		
	}

	@Override
	public  Object updateProduct(Product newProduct) {
		
		Session session = entityManager.unwrap(Session.class);
		session.update( newProduct);
		session.close();
		return newProduct;
	}
	
	



	


}
