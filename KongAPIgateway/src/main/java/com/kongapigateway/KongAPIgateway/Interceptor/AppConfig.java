package com.kongapigateway.KongAPIgateway.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AppConfig implements WebMvcConfigurer{
	
	@Autowired
    private WebInterceptor webInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(webInterceptor).addPathPatterns("/add");
	}
	
	
	
	

}
