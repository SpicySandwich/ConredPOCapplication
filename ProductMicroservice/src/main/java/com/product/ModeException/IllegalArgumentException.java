package com.product.ModeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IllegalArgumentException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public IllegalArgumentException (String message) {
		super(message);
	}

}
