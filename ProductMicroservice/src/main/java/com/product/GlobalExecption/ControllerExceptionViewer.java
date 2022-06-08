package com.product.GlobalExecption;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.ModeException.DATE_FORMAT_EXCEPTION;
import com.product.ModeException.ErrorDetail;
import com.product.ModeException.ProductExecption;
import com.product.ModeException.ProductIDnotFound;
import com.product.ModeException.ProductInternalError;
import com.product.ModeException.ProductValueNotNull;


@ControllerAdvice
public class ControllerExceptionViewer extends  ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductValueNotNull.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductValueNotNull ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(ProductExecption.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductExecption ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductInternalError.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductInternalError ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductIDnotFound.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductIDnotFound ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DATE_FORMAT_EXCEPTION.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(DATE_FORMAT_EXCEPTION ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}
	
	


	
	
	
	

}
