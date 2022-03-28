package com.cartservice;

import org.springframework.beans.factory.annotation.Autowired;

import com.cartservice.DAO.ClientDAO;
import com.grpcserver.ClientGuestGrpc.ClientGuestImplBase;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GRPCServer  extends ClientGuestImplBase{
	
	

@Autowired
private ClientDAO clientDAO;


	
	@Override
	public void insert(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		
		com.cartservice.Model.Client clientGuestRequest = new com.cartservice.Model.Client();
		
		clientGuestRequest.setClient_guest_id(request.getClientGuestId());
		clientGuestRequest.setClient_guest_name(request.getClientGuestName());
		clientGuestRequest.setClient_guest_email(request.getClientGuestEmail());
			
				
				clientDAO.insert(clientGuestRequest);
				
				APIResponse.Builder  responce = APIResponse.newBuilder();
				
				if(clientGuestRequest != null) {
					
					responce.setResponseCode(0).setResponsemessage("Succefulley added to database");
					
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
	
	}

	@Override
	public void findById(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
	
	}


}
