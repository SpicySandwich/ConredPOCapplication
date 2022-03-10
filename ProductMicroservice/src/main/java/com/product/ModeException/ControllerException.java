package com.product.ModeException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ControllerException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String producterrorcode;
	private String producterrormessage;

}
