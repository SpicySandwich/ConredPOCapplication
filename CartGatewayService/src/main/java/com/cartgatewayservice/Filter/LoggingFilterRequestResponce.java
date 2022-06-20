package com.cartgatewayservice.Filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cartgatewayservice.RestModelException.INTERNAL_ERROR;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(2)
public class LoggingFilterRequestResponce implements Filter {
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		 ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpServletRequest);
		 ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
		 
		 chain.doFilter(wrappedRequest, responseWrapper);
		 
		 String responseBody = getStringValue(wrappedRequest.getContentAsByteArray(),response.getCharacterEncoding());
		 
		 String requestBody = getStringValue(responseWrapper.getContentAsByteArray(),request.getCharacterEncoding());
	      
		        log.info(
						"\nLoggingFilterRequestResponce" 
						+"\nLocal Port: {} "
						+ "\nServer Name: {}"
						+ "\nMethod: {}"
						+ "\nRequest URI: {}"
						+ "\nServlet Path: {}"
						+ "\nRESPONCE: {}"
						+ "\nREQUEST : {}",
						request.getLocalPort(),
						request.getServerName(),
						httpServletRequest.getMethod(),
				        httpServletRequest.getRequestURI(),
				        httpServletRequest.getServletPath(),
				        responseBody,
				        requestBody
				        
						);
		        responseWrapper.copyBodyToResponse();
		
	}

	private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
	try {
		
		return new String(contentAsByteArray,0,contentAsByteArray.length,characterEncoding);
		
	} catch (UnsupportedEncodingException e) {
		
		throw new  INTERNAL_ERROR(e.getMessage());
	}
		
	}

}
