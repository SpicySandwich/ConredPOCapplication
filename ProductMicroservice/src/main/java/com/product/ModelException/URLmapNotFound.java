package com.product.ModelException;

public class URLmapNotFound extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	public URLmapNotFound  (String message) {
		super(message);
}
	
}
