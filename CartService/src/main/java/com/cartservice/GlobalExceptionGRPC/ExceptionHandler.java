package com.cartservice.GlobalExceptionGRPC;

import java.time.Instant;

import com.cartservice.ModelExceptionGRPC.DATE_EXCEPTION_GRPC;
import com.cartservice.ModelExceptionGRPC.ID_NOT_FOUND_GRPC;
import com.cartservice.ModelExceptionGRPC.INTERNAL_ERROR_GRPC;
import com.cartservice.ModelExceptionGRPC.NOT_NULL_GRPC;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.grpcserver.product.ProductServer.CartExceptionResponse;

import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ExceptionHandler {
	
	
	@GrpcExceptionHandler(DATE_EXCEPTION_GRPC.class)
	public StatusRuntimeException handledateError(DATE_EXCEPTION_GRPC cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
 
        CartExceptionResponse  cartExceptionResponse=
        		CartExceptionResponse .newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getCartErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.NOT_FOUND.getNumber())
        			.setMessage("Date Error: "+ cause.getMessage())
        			.addDetails(Any.pack(cartExceptionResponse))
        			.build();
        
        
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	
	@GrpcExceptionHandler(ID_NOT_FOUND_GRPC.class)
	public StatusRuntimeException handleIdNotFoundError(ID_NOT_FOUND_GRPC cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
        
        
        
        CartExceptionResponse  clientGuestExceptionResponse =
        		CartExceptionResponse .newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getCartErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.DATA_LOSS .getNumber())
        			.setMessage(" Not Found "+ cause.getMessage())
        			.addDetails(Any.pack(clientGuestExceptionResponse ))
        			.build();
        
        
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	
	@GrpcExceptionHandler(NOT_NULL_GRPC.class)
	public StatusRuntimeException handleNotNullError(NOT_NULL_GRPC cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
     
        
        CartExceptionResponse  clientGuestExceptionResponse =
        		CartExceptionResponse .newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getCartErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.DATA_LOSS.getNumber())
        			.setMessage("Fill up Error: "+cause.getMessage())
        			.addDetails(Any.pack(clientGuestExceptionResponse ))
        			.build();
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	
	@GrpcExceptionHandler(INTERNAL_ERROR_GRPC.class)
	public StatusRuntimeException handleInternalError(INTERNAL_ERROR_GRPC cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
     
        
        CartExceptionResponse  clientGuestExceptionResponse =
        		CartExceptionResponse .newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getCartErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.INTERNAL.getNumber())
        			.setMessage("Internal Error: "+cause.getMessage())
        			.addDetails(Any.pack(clientGuestExceptionResponse ))
        			.build();
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	
	


}
