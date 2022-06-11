package com.product.ModelException;

public class ProductInternalError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ProductInternalError (String message) {
		
		super(message);
		
	}


}
