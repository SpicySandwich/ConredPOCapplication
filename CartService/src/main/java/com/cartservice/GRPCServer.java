package com.cartservice;

import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.Empty;
import com.grpcserver.GuestClientServer.LoginRequest;
import com.grpcserver.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GRPCServer  extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
	
		System.out.println("inside kogin");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		
		APIResponse.Builder  responce = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			responce.setResponseCode(0).setResponsemessage("sucess");
			
		}else {
			
			responce.setResponseCode(10).setResponsemessage("Failed");
			
			
		}
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
	
	}
	
	

}
