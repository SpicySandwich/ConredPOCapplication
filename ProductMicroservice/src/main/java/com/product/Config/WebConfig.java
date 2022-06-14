//package com.product.Config;
//
//import java.util.Date;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.product.DAO_Hibernate_HQL.HibernateUtilModel;
//import com.product.JsonDeserializer.DateDeserializer;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//	
//	private static HibernateUtilModel hibernateUtilModel;
//	
//	@Autowired
//	public void fixautowired(HibernateUtilModel hibernateUtilModel) {
//		WebConfig.hibernateUtilModel=hibernateUtilModel;
//	}
//	
//	   @Bean
//	    public ModelMapper modelMapper() {
//	        return new ModelMapper();
//	    }
//
//	    @Bean
//	    public WebConfig webConfig() {
//	        return new WebConfig();
//	    }
//
//	    @Bean
//	    public ObjectMapper objectMapper() {
//	    	ObjectMapper mapper = new ObjectMapper();
//	        SimpleModule module = new SimpleModule();
//	        module.addDeserializer(Date.class, new DateDeserializer());
//	        mapper.configure(DeserializationFeature.WRAP_EXCEPTIONS, false);
//	        
//	        mapper.registerModule(module);
//	        return mapper;
//	    }
//}
