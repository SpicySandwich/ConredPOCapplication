package com.product.ModeException;

public class ProductInternalError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ProductInternalError (String message) {
		
		super(message);
		
	}


}
