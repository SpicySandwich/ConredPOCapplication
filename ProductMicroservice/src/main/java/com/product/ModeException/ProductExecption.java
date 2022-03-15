package com.product.ModeException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



//@Component
public class ProductExecption extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ProductExecption (String message) {
		super(message);
	}
	

	
	
	
	
	
	

}
