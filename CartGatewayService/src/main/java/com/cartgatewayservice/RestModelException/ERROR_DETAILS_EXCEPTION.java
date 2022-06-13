package com.cartgatewayservice.RestModelException;

import java.time.LocalDateTime;

import com.cartgatewayservice.Deserializer.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ERROR_DETAILS_EXCEPTION {
	
	private String message;
	private HttpStatus status;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, lenient = OptBoolean.FALSE)
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime time;

}
