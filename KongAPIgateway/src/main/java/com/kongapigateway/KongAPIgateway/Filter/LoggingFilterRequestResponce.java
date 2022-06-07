package com.kongapigateway.KongAPIgateway.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
@Order(2)
public class LoggingFilterRequestResponce implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LoggingFilterRequestResponce.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		 ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpServletRequest);
		 ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
		 
		logger.info(
				"\nRequest:" +
		        httpServletRequest.getMethod(),
		        httpServletRequest.getRequestURI(),
		        httpServletRequest.getServletPath()
				);
		
		logger.info(
				"\nLoggingFilterRequest" +
				"\nLocal Port: {} \nServer Name: {}",request.getLocalPort(),request.getServerName()
				);

	          
		 chain.doFilter(wrappedRequest, responseWrapper);
		 
		 String responseBody = new String(responseWrapper.getContentAsByteArray());
		 responseWrapper.copyBodyToResponse();
		 
         logger.info(responseBody);
	            
	            byte[] buf = wrappedRequest.getContentAsByteArray();
	 
		        if (buf.length > 0 ) {
		          
		                String requestBody = new String(buf, 0, buf.length, wrappedRequest.getCharacterEncoding());
		     
		                logger.info(requestBody);
		              
	      
		            }
		
	}

}
