package com.kongapigateway.KongAPIgateway.GlobalException;



import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.kongapigateway.KongAPIgateway.ModelException.DATE_FORMAT_ERROR;
import com.kongapigateway.KongAPIgateway.ModelException.ErrorDetail;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductIDnotFound;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionViewer extends  ResponseEntityExceptionHandler {
	
	private ZoneOffset zoneOffSet = ZoneOffset.of("+08:00");
	
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ProductExecption.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductExecption ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(ProductIDnotFound.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductIDnotFound ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductValueNotNull.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductValueNotNull ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(DATE_FORMAT_ERROR.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(DATE_FORMAT_ERROR ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	

}
