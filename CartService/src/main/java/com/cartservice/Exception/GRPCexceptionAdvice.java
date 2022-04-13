package com.cartservice.Exception;

import java.time.Instant;

import com.cartservice.ExceptionModel.ClientGuestDuplicateEmail;
import com.cartservice.ExceptionModel.ClientGuestNotFound;
import com.cartservice.ExceptionModel.ClientGuestNotNull;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.grpcserver.GuestClientServer.ClientGuestExceptionResponse;

import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GRPCexceptionAdvice {
	
	@GrpcExceptionHandler(ClientGuestNotFound.class)
	public StatusRuntimeException handleNotFoundError(ClientGuestNotFound cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
        
        
        
        ClientGuestExceptionResponse clientGuestExceptionResponse =
        	ClientGuestExceptionResponse.newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.NOT_FOUND.getNumber())
        			.setMessage("Client Guest ID not Found")
        			.addDetails(Any.pack(clientGuestExceptionResponse ))
        			.build();
        
        
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	
	@GrpcExceptionHandler(ClientGuestNotNull.class)
	public StatusRuntimeException handleNotNullError(ClientGuestNotNull cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
        
        
        
        ClientGuestExceptionResponse clientGuestExceptionResponse =
        	ClientGuestExceptionResponse.newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getClientGuestErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.DATA_LOSS .getNumber())
        			.setMessage("Please Fill up all the Details/Must not contain null value")
        			.addDetails(Any.pack(clientGuestExceptionResponse ))
        			.build();
        
        
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	
	@GrpcExceptionHandler(ClientGuestDuplicateEmail.class)
	public StatusRuntimeException handleDuplicateIDError(ClientGuestDuplicateEmail cause) {

		Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        
     
        
        ClientGuestExceptionResponse clientGuestExceptionResponse =
        	ClientGuestExceptionResponse.newBuilder()
        	.setTimestamp(timestamp)
        	.setErrorCode(cause.getClientGuestErrorCode())
        	.build();
        	
        	Status status  = Status.newBuilder()
        			.setCode(Code.ALREADY_EXISTS.getNumber())
        			.setMessage("Email is already exists ")
        			.addDetails(Any.pack(clientGuestExceptionResponse ))
        			.build();
        
        	return StatusProto.toStatusRuntimeException(status);
		
	}
	

}
