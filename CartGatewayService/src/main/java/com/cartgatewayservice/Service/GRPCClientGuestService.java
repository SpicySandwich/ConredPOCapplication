package com.cartgatewayservice.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartgatewayservice.BodyConvertParameters.ConvertParameters;
import com.cartgatewayservice.Model.GuestClient;
import com.cartgatewayservice.RestModelException.EXISTING_EMAIL_EXCEPTION;
import com.cartgatewayservice.RestModelException.ID_NOT_FOUND;
import com.google.protobuf.Int32Value;
import com.grpcserver.ClientGuestServiceGrpc;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class GRPCClientGuestService {

@Autowired
private ConvertParameters convertParameters;
	
		
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
	
	public String inserdata(GuestClient guestClient) {
		
		try {
			
			ClientGuestServiceGrpc.ClientGuestServiceBlockingStub stub = ClientGuestServiceGrpc.newBlockingStub(channel);
	
	APIResponse response = stub.insert(ClientGuest.newBuilder()
			.setClientGuestId(convertParameters.convertToint32value(guestClient.getClient_guest_id()))
			.setClientGuestName(convertParameters.convertStringValue(guestClient.getClient_guest_name()))
			.setClientGuestEmail(convertParameters.convertStringValue(guestClient.getClient_guest_email()))
			.build());
	return response.getResponsemessage();
	
} catch (Exception e) {
	
	throw new EXISTING_EMAIL_EXCEPTION("Email is existed");

}

	}
	
	public String deletedata(Integer client_guest_id) {


		ClientGuestServiceGrpc.ClientGuestServiceBlockingStub stub = ClientGuestServiceGrpc.newBlockingStub(channel);
		GuestClient guestClient = new GuestClient();
		
		guestClient.setClient_guest_id(client_guest_id);
		
		APIResponse response = stub.deleteById(ClientGuest.newBuilder()
				.setClientGuestId(convertParameters.convertToint32value(guestClient.getClient_guest_id()))
				.build());
	
		return response.getResponsemessage();
}
	
	public String updatedata(GuestClient guestClient) {


	ClientGuestServiceGrpc.ClientGuestServiceBlockingStub stub = ClientGuestServiceGrpc.newBlockingStub(channel);
	APIResponse response = stub.update(ClientGuest.newBuilder()
			.setClientGuestId(convertParameters.convertToint32value(guestClient.getClient_guest_id()))
			.setClientGuestName(convertParameters.convertStringValue(guestClient.getClient_guest_name()))
			.setClientGuestEmail(convertParameters.convertStringValue(guestClient.getClient_guest_email()))
		
			.build());
	
	return response.getResponsemessage();
			
	}
	

	public GuestClient findClient (Integer client_guest_id) {
		ClientGuestServiceGrpc.ClientGuestServiceBlockingStub stub = ClientGuestServiceGrpc.newBlockingStub(channel);
		GuestClient guestClient = new GuestClient();
		
			try {
				
				ClientGuest clientGuestRequest = stub.findById(Int32Value.of(client_guest_id));
				
				guestClient.setClient_guest_id(convertParameters.convertJavaInteger(clientGuestRequest.getClientGuestId()));
				guestClient.setClient_guest_name(convertParameters.convertJavaString(clientGuestRequest.getClientGuestName()));
				guestClient.setClient_guest_email(convertParameters.convertJavaString(clientGuestRequest.getClientGuestEmail()));
			
				
				
			} catch (Exception e) {
				throw new ID_NOT_FOUND("Product ID " +client_guest_id + " not found. ");
				
			}

		return guestClient;

		

	}
	
	
//	public ClientGuestrList list(List<ClientGuest> clientlist) {
//		ClientGuestServiceGrpc.ClientGuestServiceBlockingStub stub = ClientGuestServiceGrpc.newBlockingStub(channel);
//		//ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);
//		ClientGuestrList.Builder reBuilder = ClientGuestrList.newBuilder();
//		clientlist.forEach(reBuilder::addClientguestall);
//		
//		ClientGuestrList reClientGuestrList = reBuilder.build();
//		
//		return reClientGuestrList;
//		
//	}
	


	
}
