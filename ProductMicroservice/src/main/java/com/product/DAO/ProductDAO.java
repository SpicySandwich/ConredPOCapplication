package com.product.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.Entity.Product;


@Repository
public class ProductDAO implements ProductDAOImpl {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> getProduct() {
	
		Session session = entityManager.unwrap(Session.class);
				Query<Product> query = session.createQuery("select * from information_schema.tb_product where auto_increment is not null", Product.class);
				List<Product>list = query.getResultList();
				return list;
	}

	@Override
	public Product get(long productid) {
		
		return null;
	}

	@Override
	public void save(Product product) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
		
	}

	@Override
	public void delete(int id) {
	
		
	}

}
