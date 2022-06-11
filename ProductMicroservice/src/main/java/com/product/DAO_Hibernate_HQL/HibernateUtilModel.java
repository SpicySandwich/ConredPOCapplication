package com.product.DAO_Hibernate_HQL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class HibernateUtilModel {
	
	
	@Value("${spring.datasource.url}")
	private  String url;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	
	@Value("${spring.datasource.username}")
	private  String user;
	
	@Value("${spring.datasource.password}")
	private String pass;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private  String dialect;
	
	@Value("${spring.jpa.show-sql}")
	private String show_sql;
	
	@Value("${spring.jpa.hibernate.naming.implicit-strategy}")
	private String IMPLICIT;
	
	@Value("${spring.jpa.hibernate.naming.physical-strategy}")
	private  String PHYSICAL;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private  String update;
	

	

}
