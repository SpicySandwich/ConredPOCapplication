package com.cartgatewayservice;



import org.springframework.stereotype.Service;

import com.grpcserver.ClientGuestGrpc;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class GRPCClientGuestService {

	
	public String inserdata() {
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
	

	ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);
	
	
	APIResponse response = stub.insert(ClientGuestRequest.newBuilder()
			.setClientGuestId(0)
			.setClientGuestName("")
			.setClientGuestEmail("")
			.build());
	
	channel.shutdown();
	
	return response.getResponsemessage();
			
	}
}
