package com.cartgatewayservice.ErrorAdvice;



import com.cartgatewayservice.ErrorModel.NotFoundException;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GlobalExceptionHandler {
	
	@GrpcExceptionHandler(NotFoundException.class)
	public Status handleInvalidArgument(NotFoundException e) {
		return Status.fromCode(Status.Code.NOT_FOUND)
		         .withDescription("Data cannot be found")
			 .withCause(e);
    }
}
