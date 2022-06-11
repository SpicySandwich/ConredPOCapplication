package com.product.Interceptor;

import com.product.KafkaProducer.ProductProducerKafkaTopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfigController implements WebMvcConfigurer{
	
@Autowired
ProductProducerKafkaTopic productProducerKafkaTopic;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new WebInterceptor(productProducerKafkaTopic)).addPathPatterns("/product/**");
	}
	
	
	
	

}
