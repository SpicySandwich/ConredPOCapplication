package com.cartgatewayservice.Service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.cartgatewayservice.Model.ClientEntity;
import com.grpcserver.ClientGuestGrpc;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.ClientGuestrList;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class GRPCClientGuestService {
	
	private ClientGuestGrpc.ClientGuestBlockingStub stub;
		
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
	

	public String findData(Integer client_guest_id) {

		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

	ClientEntity clientEntity = new ClientEntity();
		
		APIResponse response = stub.findById(ClientGuestRequest.newBuilder()
				.setClientGuestId(client_guest_id)
				.build());
			
		return response.getResponsemessage();
	}
	
	public  List<ClientGuestRequest> getAllCLientData(ClientGuestRequest clientGuestRequest) {
		

		ClientGuestrList clientGuestrList = stub.findAllByFilter(clientGuestRequest);
		return clientGuestrList.getClientguestallList();
		
	}



}
