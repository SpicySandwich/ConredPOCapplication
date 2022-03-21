package com.product.GlobalExecption;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.product.ModeException.ErrorDetail;
import com.product.ModeException.ProductExecption;
import com.product.ModeException.ProductInternalError;
import com.product.ModeException.ProductNullExecption;

@ControllerAdvice
public class ControllerExceptionViewer extends  ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductExecption.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductExecption ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ProductInternalError.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductInternalError ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ProductNullExecption.class)
	public ResponseEntity<Object> handleProductExceptionNotFound(ProductNullExecption ex, WebRequest request){
		
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	}


	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	

}
