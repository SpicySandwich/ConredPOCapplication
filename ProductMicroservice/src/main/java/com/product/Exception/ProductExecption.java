package com.product.Exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Component
public class ProductExecption extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	private String producterrorcode;
	private String producterrormessage;
	
	public String getProducterrorcode() {
		
		return producterrorcode;
	}
	public void setProducterrorcode(String producterrorcode) {
		this.producterrorcode = producterrorcode;
	}
	public String getProducterrormessage() {
		return producterrormessage;
	}
	public void setProducterrormessage(String producterrormessage) {
		this.producterrormessage = producterrormessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ProductExecption() {
		super();
	}
	public ProductExecption(String producterrorcode, String producterrormessage) {
		super();
		this.producterrorcode = producterrorcode;
		this.producterrormessage = producterrormessage;
	}
	
	
	
	
	
	
	

}
