package com.product.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.product.Entity.Product;

@Repository
public class ProductDAOImpl  implements ProductDAO{
	
	
	

	
	@Override
	public List<Product> getProduct() {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Product> query = session.createQuery("FROM Product", Product.class);
		List<Product>list = query.getResultList();
		session.close();
		return list;
		
	}
	
	@Override
	public  Object updateProduct(Product product)  {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

		
			String hql = "UPDATE Product  set "
					+ "productname = :productname, "
					+ "productbrand = :productbrand, " 
					+ "productprice = :productprice ," 
					+ "productdescription = :productdescription," 
					+ "productquantity= :productquantity ," 
					+ "productexpirationdate = :productexpirationdate " 
					+ "WHERE purchase_item = :purchase_item";
			
			Query query = session.createQuery(hql);
			query.setParameter("productname", product.getProductname());
			query.setParameter("productbrand", product.getProductbrand());
			query.setParameter("productprice",product.getProductprice());
			query.setParameter("productdescription", product.getProductdescription());
			query.setParameter("productquantity", product.getProductquantity());
			query.setParameter("productexpirationdate", product.getProductexpirationdate());
			query.setParameter("purchase_item",product.getPurchase_item());
		     query.executeUpdate();

			transaction.commit();
	
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public Product getPoductInfo(Integer purchase_item) { 

	        Transaction transaction = null;
	        Product product = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	       
	            transaction = session.beginTransaction();

	            String hql = " FROM Product  S WHERE S.purchase_item = :purchase_item";
	            Query query = session.createQuery(hql);
	            query.setParameter("purchase_item", purchase_item);
	            List results = query.getResultList();
	            session.close();

	            if (results != null && !results.isEmpty()) {
	            	product = (Product ) results.get(0);
	            }
	      
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return product;
	    }
	
	@Override
	public Product delete(Integer purchase_item) {
		
		Transaction transaction = null;
		Product product = new Product();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      
            transaction = session.beginTransaction();

            product = session.get(Product.class, purchase_item);
            if (product != null) {
                String hql = "DELETE FROM Product " + "WHERE purchase_item = :purchase_item";
                Query query = session.createQuery(hql);
                query.setParameter("purchase_item", purchase_item);
                query.executeUpdate();
                
            }

            transaction.commit();
   
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return product;
	
	}
	

	
	@Override
	public Product save(Product product) {
		Transaction transaction = null;
		  
        Session session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            String hql = "INSERT INTO Product  ( productname, productbrand, productprice, productdescription, productquantity, productexpirationdate) " +
                "SELECT   productname, productbrand, productprice, productdescription, productquantity, productexpirationdate FROM Product ";
            Query query = session.createQuery(hql);
            Integer result =  query.executeUpdate();
        
            transaction.commit();
            
            
            if (result == 0 ||result == null  ) {
                   
                throw new NullPointerException();
            }
            

        return product;
    }
	
	public Product saveStudent(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Object object = session.save(product);
			
			session.get(Product.class, (Serializable) object);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return product;
	}
	


}
