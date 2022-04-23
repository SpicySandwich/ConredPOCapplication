package com.product.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.Entity.ClientGuest;
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
	             "WHERE productid = :productid";
		Product productObj = session.get(Product.class, purchase_item);
	Query query = session.createQuery(hql);
	query.setParameter("productid",purchase_item);
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
	
	
	//test
	
	public ClientGuest saveClient(ClientGuest product) {
		Session session = entityManager.unwrap(Session.class);
		    session.save(product);
		    session.close();
			return product;

		
	}
	
	public List<ClientGuest> getClientGuestt() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<ClientGuest> query = session.createQuery("FROM ClientGuest", ClientGuest.class);
		List<ClientGuest>list = query.getResultList();
		session.close();
		return list;
		
	}
	
	public ClientGuest getPoductInfo2(Integer purchase_item) {
		
		Session session = entityManager.unwrap(Session.class);
		ClientGuest productObj =	session.get(ClientGuest.class, purchase_item);
	    session.close();
	    return productObj;
		
	}


	


}
