package com.product.Filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.KafkaProducer.ProductProducerKafkaTopic;
import com.product.ModelException.ProductInternalError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(2)
public class LoggingFilterRequestResponce implements Filter {
	
	@Autowired
	private ProductProducerKafkaTopic productProducerKafkaTopic;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		 ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpServletRequest);
		 ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
		 
 chain.doFilter(wrappedRequest, responseWrapper);
 
		 String requestBody = getStringValue(wrappedRequest.getContentAsByteArray(),request.getCharacterEncoding());
		 String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),response.getCharacterEncoding());
	      
		        log.info(
						"\nLoggingFilterRequestResponce" 
						+"\nLocal Port: {} "
						+ "\nServer Name: {}"
						+ "\nMethod: {}"
						+ "\nRequest URI: {}"
						+ "\nServlet Path: {}"
						+ "\nREQUEST : {}"
						+ "\nRESPONCE: {}",
						request.getLocalPort(),
						request.getServerName(),
						httpServletRequest.getMethod(),
				        httpServletRequest.getRequestURI(),
				        httpServletRequest.getServletPath(),
				        requestBody,
				        responseBody
				        
				        
						);
		        //to kafka topic
		        if (log.isInfoEnabled()) {
		        	
		        	 String message = MessageFormat.format(
		        			 "\nLoggingFilterRequestResponce" 
								+"\nLocal Port: {0} "
								+ "\nServer Name: {1}"
								+ "\nMethod: {2}"
								+ "\nRequest URI: {3}"
								+ "\nServlet Path: {4}"
								+ "\nREQUEST : {5}"
								+ "\nRESPONCE: {6}",
								request.getLocalPort(),
								request.getServerName(),
								httpServletRequest.getMethod(),
						        httpServletRequest.getRequestURI(),
						        httpServletRequest.getServletPath(),
						        requestBody,
						        responseBody);
		             
		        	 productProducerKafkaTopic.sendMessageDTO(message);
				}
		       
		        responseWrapper.copyBodyToResponse();
		        
		
	}

	private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
	try {
		
		return new String(contentAsByteArray,0,contentAsByteArray.length,characterEncoding);
		
	} catch (UnsupportedEncodingException e) {
		
		throw new  ProductInternalError(e.getMessage());
	}
		
	}
		 


}
