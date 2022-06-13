package com.product.GlobalExecption;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.product.ModelException.DATE_FORMAT_EXCEPTION;
import com.product.ModelException.ErrorDetail;
import com.product.ModelException.ProductExecption;
import com.product.ModelException.ProductIDnotFound;
import com.product.ModelException.ProductInternalError;
import com.product.ModelException.ProductValueNotNull;

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
	
	
	private ZoneOffset zoneOffSet= ZoneOffset.of("+08:00");
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
			
	}


	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductValueNotNull.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductValueNotNull ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(ProductExecption.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductExecption ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductInternalError.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductInternalError ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductIDnotFound.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductIDnotFound ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DATE_FORMAT_EXCEPTION.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(DATE_FORMAT_EXCEPTION ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	}
	
	


	
	
	
	

}
