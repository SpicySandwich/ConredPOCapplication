package com.kongapigateway.KongAPIgateway.ModelException;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetail {
	
	private String message;
	private HttpStatus status;
	private LocalDateTime time;

}
