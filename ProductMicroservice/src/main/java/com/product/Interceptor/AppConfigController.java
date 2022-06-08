package com.product.Interceptor;

import com.product.KafkaProducer.ProductProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfigController implements WebMvcConfigurer{
	
@Autowired
ProductProducer productProducer;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new WebInterceptor(productProducer)).addPathPatterns("/product/**");
	}
	
	
	
	

}
