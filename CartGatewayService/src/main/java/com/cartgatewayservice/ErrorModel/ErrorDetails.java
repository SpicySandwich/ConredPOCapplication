package com.cartgatewayservice.ErrorModel;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	
	private String message;
	private HttpStatus status;
	private LocalDateTime time;

}
