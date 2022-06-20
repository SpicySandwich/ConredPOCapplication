package com.cartgatewayservice.GlobalAdviceException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.cartgatewayservice.RestModelException.ERROR_DETAILS_EXCEPTION;
import com.cartgatewayservice.RestModelException.ID_NOT_FOUND;
import com.cartgatewayservice.RestModelException.INTERNAL_ERROR;
import com.cartgatewayservice.RestModelException.NOT_NULL_EXCEPTION;



@ControllerAdvice
public class RestAdviceException extends ResponseEntityExceptionHandler {
	
	private ZoneOffset zoneOffSet= ZoneOffset.of("+08:00");
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(NOT_NULL_EXCEPTION.class)
	public ResponseEntity<Object> handleNotNullException(NOT_NULL_EXCEPTION ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	
	}
	

	
	@ExceptionHandler(ID_NOT_FOUND.class)
	public ResponseEntity<Object> handleNoIDFoundException(ID_NOT_FOUND ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now(zoneOffSet)),HttpStatus.NOT_FOUND);
		
	
	}
	
	@ExceptionHandler(DATE_FORMAT_EXCEPTION.class)
	public ResponseEntity<Object> handleFormatDateEntity(DATE_FORMAT_EXCEPTION ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now(zoneOffSet)),HttpStatus.UNPROCESSABLE_ENTITY);
		
	
	}
	
	@ExceptionHandler(INTERNAL_ERROR.class)
	public ResponseEntity<Object> handleFormatDateEntity(INTERNAL_ERROR ex, WebRequest request) {
		return new ResponseEntity<Object>(new ERROR_DETAILS_EXCEPTION(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(zoneOffSet)),HttpStatus.INTERNAL_SERVER_ERROR);
		
	
	}


	
	
	
	
	
	
	
	

}
