package com.cartgatewayservice.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cartgatewayservice.Model.GuestClient;
import com.google.protobuf.Int32Value;
import com.grpcserver.ClientGuestGrpc;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.ClientGuestrList;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class GRPCClientGuestService {


	
		
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
	
	public String inserdata(GuestClient guestClient) {

	ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

	APIResponse response = stub.insert(ClientGuestRequest.newBuilder()
			.setClientGuestId(0)
			.setClientGuestName(guestClient.getClient_guest_name())
			.setClientGuestEmail(guestClient.getClient_guest_email())
			.build());
	
	return response.getResponsemessage();
			
	}
	
	public String deletedata(Integer client_guest_id) {

		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

		GuestClient guestClient = new GuestClient();
		
		guestClient.setClient_guest_id(client_guest_id);
		
		APIResponse response = stub.deleteById(ClientGuestRequest.newBuilder()
				.setClientGuestId(guestClient.getClient_guest_id())
				.build());
	
		return response.getResponsemessage();
}
	
	public String updatedata(GuestClient guestClient) {

	ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

	APIResponse response = stub.update(ClientGuestRequest.newBuilder()
			.setClientGuestId(guestClient.getClient_guest_id())
			.setClientGuestName(guestClient.getClient_guest_name())
			.setClientGuestEmail(guestClient.getClient_guest_email())
			.build());
	
	return response.getResponsemessage();
			
	}
	

	public GuestClient findClient (Integer client_guest_id) {
			
		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);
		GuestClient guestClient = new GuestClient();

		ClientGuestRequest clientGuestRequest = stub.findById(Int32Value.of(client_guest_id));
			
			guestClient.setClient_guest_id(clientGuestRequest.getClientGuestId());
			guestClient.setClient_guest_name(clientGuestRequest.getClientGuestName());
			guestClient.setClient_guest_email(clientGuestRequest.getClientGuestEmail());
		
		
		return guestClient;

		

	}
	
	
	public ClientGuestrList list(List<ClientGuestRequest> clientlist) {
		
		ClientGuestrList.Builder reBuilder = ClientGuestrList.newBuilder();
		clientlist.forEach(reBuilder::addClientguestall);
		
		ClientGuestrList reClientGuestrList = reBuilder.build();
		
		return reClientGuestrList;
		
	}
	


	
}
