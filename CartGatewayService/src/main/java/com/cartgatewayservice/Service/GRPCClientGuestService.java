package com.cartgatewayservice.Service;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.cartgatewayservice.Model.ClientEntity;
import com.google.protobuf.Int32Value;
import com.grpcserver.ClientGuestGrpc;
import com.grpcserver.GuestClientServer;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.ClientGuestRequestOrBuilder;
import com.grpcserver.GuestClientServer.ClientGuestRequestOutput;
import com.grpcserver.GuestClientServer.ClientGuestRequestOutputOrBuilder;
import com.grpcserver.GuestClientServer.ClientGuestrList;
import com.grpcserver.GuestClientServer.ClientGuestrListOrBuilder;
import com.grpcserver.GuestClientServer.Empty;
import com.grpcserver.GuestClientServer.Empty.Builder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.var;


@Service
public class GRPCClientGuestService {

	
		
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
	
	public String inserdata(ClientEntity clientEntity) {

	ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

	APIResponse response = stub.insert(ClientGuestRequest.newBuilder()
			.setClientGuestId(0)
			.setClientGuestName(clientEntity.getClient_guest_name())
			.setClientGuestEmail(clientEntity.getClient_guest_email())
			.build());
	
	return response.getResponsemessage();
			
	}
	
	public String deletedata(Integer client_guest_id) {

		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

		ClientEntity clientEntity = new ClientEntity();
		
		clientEntity.setClient_guest_id(client_guest_id);
		
		APIResponse response = stub.deleteById(ClientGuestRequest.newBuilder()
				.setClientGuestId(clientEntity.getClient_guest_id())
				.build());
	
		return response.getResponsemessage();
}
	
	public String updatedata(ClientEntity clientEntity) {

	ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

	APIResponse response = stub.update(ClientGuestRequest.newBuilder()
			.setClientGuestId(clientEntity.getClient_guest_id())
			.setClientGuestName(clientEntity.getClient_guest_name())
			.setClientGuestEmail(clientEntity.getClient_guest_email())
			.build());
	
	return response.getResponsemessage();
			
	}
	

	public ClientEntity findClient (Integer client_guest_id) {
		
		
		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);
	
		ClientEntity clientEntity = new ClientEntity();
		
		ClientGuestRequest clientGuestRequest = stub.findById(Int32Value.of(client_guest_id));
			
			clientEntity.setClient_guest_id(clientGuestRequest.getClientGuestId());
			clientEntity.setClient_guest_name(clientGuestRequest.getClientGuestName());
			clientEntity.setClient_guest_email(clientGuestRequest.getClientGuestEmail());
			
			
		
		return clientEntity;

		

	}
	
	
	public ClientGuestrList list(List<ClientGuestRequest> clientlist) {
		
		ClientGuestrList.Builder reBuilder = ClientGuestrList.newBuilder();
		clientlist.forEach(reBuilder::addClientguestall);
		
		ClientGuestrList reClientGuestrList = reBuilder.build();
		
		return reClientGuestrList;
		
	}
	


	
}
