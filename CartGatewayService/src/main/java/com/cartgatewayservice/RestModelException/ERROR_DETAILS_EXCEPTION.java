package com.cartgatewayservice.RestModelException;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ERROR_DETAILS_EXCEPTION {
	
	private String message;
	private HttpStatus status;
	private LocalDateTime time;

}
