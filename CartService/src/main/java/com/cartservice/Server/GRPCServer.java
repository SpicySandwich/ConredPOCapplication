package com.cartservice.Server;

import org.springframework.beans.factory.annotation.Autowired;
import com.cartservice.Service.GuestClientServiceImpl;
import com.grpcserver.ClientGuestGrpc.ClientGuestImplBase;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GRPCServer  extends ClientGuestImplBase{
	


@Autowired
private GuestClientServiceImpl guestClientServiceImpl;


com.cartservice.Model.Client clientGuestRequest = new com.cartservice.Model.Client();

	
	@Override
	public void insert(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		
		
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
	public void findAll(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
	
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
	public void findById(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		
		Integer clientid = request.getClientGuestId();
	
		
		
		
		guestClientServiceImpl.getGuestClientInfo(clientid);

				APIResponse.Builder  responce = APIResponse.newBuilder();
				responce.setResponseCode(0).setResponsemessage("Succefulley added to database " + clientGuestRequest);

				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();


	}

	@Override
	public void update(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {

		
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
	
	


}
