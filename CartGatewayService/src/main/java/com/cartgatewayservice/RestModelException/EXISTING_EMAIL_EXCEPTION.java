package com.cartgatewayservice.RestModelException;

public class EXISTING_EMAIL_EXCEPTION extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EXISTING_EMAIL_EXCEPTION(String message) {
		super(message);
	}

}
