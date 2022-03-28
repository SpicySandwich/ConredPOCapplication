package com.cartgatewayservice;

import org.springframework.stereotype.Service;

import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.LoginRequest;
import com.grpcserver.userGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class GRPCClientGuestService {

	
	public String test() {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
	

	userGrpc.userBlockingStub stub = userGrpc.newBlockingStub(channel);
	
	
	APIResponse response = stub.login(LoginRequest.newBuilder()
			.setUsername("")
			.setPassword("")
			.build());
	
	channel.shutdown();
	
	return response.getResponsemessage();
			
	}
}
