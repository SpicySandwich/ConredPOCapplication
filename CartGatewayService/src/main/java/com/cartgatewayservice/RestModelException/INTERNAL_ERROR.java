package com.cartgatewayservice.RestModelException;

public class INTERNAL_ERROR extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public  INTERNAL_ERROR (String message) {
		super(message);
	}


}
