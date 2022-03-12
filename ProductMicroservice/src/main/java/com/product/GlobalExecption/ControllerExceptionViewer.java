package com.product.GlobalExecption;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.product.ModeException.ErrorDetail;
import com.product.ModeException.ProductExecption;

@ControllerAdvice
public class ControllerExceptionViewer extends Exception {

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> resourceNotFoundHandling(IllegalArgumentException exception, WebRequest request){
		ErrorDetail errorDetails = 
				new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ProductExecption.class)
	public ResponseEntity<?> resourceNotFoundHandling(ProductExecption exception, WebRequest request){
		ErrorDetail errorDetails = 
				new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetail errorDetails = 
				new ErrorDetail (new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	

}
