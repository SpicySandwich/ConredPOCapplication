package com.cartgatewayservice.RestModelException;

public class NOT_NULL_EXCEPTION extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NOT_NULL_EXCEPTION (String message) {
		super(message);
	}

}
