package com.product.DAO_Hibernate_HQL;

import java.util.Properties;

import com.product.Entity.Product;
import com.product.ModelException.ProductInternalError;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;





@Component
public class HibernateUtil {
	
	
	private static  HibernateUtilModel hibernateUtilModel;
	
	private static SessionFactory sessionFactory;
	
	
	@Autowired
    public void autowairedFixStatic(HibernateUtilModel hibernateUtilModel){
		HibernateUtil.hibernateUtilModel= hibernateUtilModel;
    }
	
    public static SessionFactory getSessionFactory() {
    	
    	
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, hibernateUtilModel.getDriver());
                settings.put(Environment.URL, hibernateUtilModel.getUrl());
                settings.put(Environment.USER, hibernateUtilModel.getUser());
                settings.put(Environment.PASS, hibernateUtilModel.getPass());
                settings.put(Environment.DIALECT, hibernateUtilModel.getDialect());

                settings.put(Environment.SHOW_SQL, hibernateUtilModel.getShow_sql());
                settings.put(Environment.IMPLICIT_NAMING_STRATEGY,hibernateUtilModel.getIMPLICIT());
                settings.put(Environment.PHYSICAL_NAMING_STRATEGY,hibernateUtilModel.getPHYSICAL());
                
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, hibernateUtilModel.getContext());
                
                settings.put(Environment.HBM2DDL_AUTO, hibernateUtilModel.getUpdate());
                settings.put(Environment.AUTOCOMMIT,hibernateUtilModel.getCommit());

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Product.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
            	throw new ProductInternalError(e.getMessage());
            }
        }
        return sessionFactory;
    }
    


}
