package com.kongapigateway.KongAPIgateway.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	


	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new WebInterceptor()).addPathPatterns("/cart/**").order(1);
		registry.addInterceptor(new WebInterceptor()).addPathPatterns("/product/**").order(2);
	}
	
	
	
	

}
