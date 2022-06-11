package com.product.ModelException;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorDetail {
	
	
	private String message;
	private HttpStatus status;
	private LocalDateTime time;
	
	


}
