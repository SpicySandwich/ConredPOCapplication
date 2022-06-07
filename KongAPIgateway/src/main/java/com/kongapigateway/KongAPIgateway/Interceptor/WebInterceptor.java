package com.kongapigateway.KongAPIgateway.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class WebInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 	{
		logger.info("preHandle..{}:{}",request.getRequestURI(),request.getMethod());
	
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle..{}:{}",request.getRequestURI(),request.getMethod());
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.info("afterCompletion..{}:{}",request.getRequestURI(),request.getMethod());
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	


	
	
	
	

}
