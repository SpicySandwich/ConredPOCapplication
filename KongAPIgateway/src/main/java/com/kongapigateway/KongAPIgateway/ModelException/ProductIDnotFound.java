package com.kongapigateway.KongAPIgateway.ModelException;

public class ProductIDnotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductIDnotFound(String message) {
		super(message);
	}
}
