package com.cartservice.Server;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cartservice.DAO.ClientDAO;
import com.cartservice.Model.Client;
import com.cartservice.Service.GuestClientServiceImpl;
import com.grpcserver.ClientGuestGrpc.ClientGuestImplBase;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.ClientGuestrList;
import com.grpcserver.GuestClientServer.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GRPCServer  extends ClientGuestImplBase{
	

@Autowired
private GuestClientServiceImpl guestClientServiceImpl;


	@Override
	public void insert(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		com.cartservice.Model.Client clientGuestRequest = new com.cartservice.Model.Client();
		
		Integer clientid = request.getClientGuestId();
		String clientname = request.getClientGuestName();
		String clientemail = request.getClientGuestEmail();
		
		
		clientGuestRequest.setClient_guest_id(clientid);
		clientGuestRequest.setClient_guest_name(clientname);
		clientGuestRequest.setClient_guest_email(clientemail);
		
		
		guestClientServiceImpl.saveGuestClientInfo(clientGuestRequest);

				
				APIResponse.Builder  responce = APIResponse.newBuilder();
				
				if(clientGuestRequest != null) {
					
					responce.setResponseCode(0).setResponsemessage("Succefulley added to database " + clientGuestRequest);
					
				}else{
					
					responce.setResponseCode(8).setResponsemessage("Failed to add data in database");
				}
			
				
				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();
			

	}
	
	
	@Override
	public void deleteById(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		

		Integer clientid = request.getClientGuestId();
	
		
		
		
		guestClientServiceImpl.deleteGuestClientInfo(clientid);

				APIResponse.Builder  responce = APIResponse.newBuilder();

				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();
	
	}



	@Override
	public void update(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		com.cartservice.Model.Client clientGuestRequest = new com.cartservice.Model.Client();
		
		Integer clientid = request.getClientGuestId();
		String clientname = request.getClientGuestName();
		String clientemail = request.getClientGuestEmail();
		
		clientGuestRequest.setClient_guest_id(clientid);
		clientGuestRequest.setClient_guest_name(clientname);
		clientGuestRequest.setClient_guest_email(clientemail);
		
		
		guestClientServiceImpl.updateGuestClientInfo(clientGuestRequest);

				
				APIResponse.Builder  responce = APIResponse.newBuilder();
					
				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();
		
	}
	
	@Override
	public void findById(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		
		com.cartservice.Model.Client clientGuestRequest = guestClientServiceImpl.getGuestClientInfo( request.getClientGuestId());

				APIResponse.Builder  responce = APIResponse.newBuilder();
				responce.setResponseCode(0).setResponsemessage("Succefull view your the data " + clientGuestRequest);

				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();


	}


	@Override
	public void findAll(Empty request, StreamObserver<ClientGuestRequest> responseObserver) {
		List<Client> list = guestClientServiceImpl.getAll();
		
	for(Client client : list) {
		
		responseObserver.onNext(client.toGuest());
		
	}
	   responseObserver.onCompleted();
	}

	

}
