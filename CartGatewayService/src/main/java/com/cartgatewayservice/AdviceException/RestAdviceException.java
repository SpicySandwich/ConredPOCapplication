package com.cartgatewayservice.AdviceException;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.cartgatewayservice.RestModelException.ERROR_DETAILS_EXCEPTION;
import com.cartgatewayservice.RestModelException.EXISTING_EMAIL_EXCEPTION;
import com.cartgatewayservice.RestModelException.ID_NOT_FOUND;
import com.cartgatewayservice.RestModelException.NOT_NULL_EXCEPTION;



@ControllerAdvice
public class RestAdviceException extends ResponseEntityExceptionHandler {
	

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NOT_NULL_EXCEPTION.class)
	public ResponseEntity<Object> handleNotNullException(NOT_NULL_EXCEPTION ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	
	}
	
	@ExceptionHandler(EXISTING_EMAIL_EXCEPTION.class)
	public ResponseEntity<Object> handleExisitingEmailException(EXISTING_EMAIL_EXCEPTION ex,  WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	
	}
	
	@ExceptionHandler(ID_NOT_FOUND.class)
	public ResponseEntity<Object> handleNoIDFoundException(ID_NOT_FOUND ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	
	}
	
	@ExceptionHandler(DATE_FORMAT_EXCEPTION.class)
	public ResponseEntity<Object> handleNoIDFoundException(DATE_FORMAT_EXCEPTION ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now()),HttpStatus.NOT_FOUND);
		
	
	}
	
	

}
