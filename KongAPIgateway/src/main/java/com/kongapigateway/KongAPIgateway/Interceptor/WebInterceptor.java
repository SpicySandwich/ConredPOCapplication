package com.kongapigateway.KongAPIgateway.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WebInterceptor implements HandlerInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 	{
		return true;
	}

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		logger.error("WebInterceptor posthandle is now logged");
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.error("WebInterceptor afterCompletion is now logged");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	


	
	
	
	

}
