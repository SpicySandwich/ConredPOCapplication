package com.cartservice;

import com.grpcserver.ClientGuestGrpc.ClientGuestImplBase;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GRPCServer  extends ClientGuestImplBase{
	
	

	@Override
	public void clientGuestData(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
	
		System.out.println("inside kogin");
		
		Integer clientid = request.getClientGuestId();
		String clientname = request.getClientGuestName();
		String clientemail = request.getClientGuestEmail();
		
		
		
		APIResponse.Builder  responce = APIResponse.newBuilder();
		if( clientid != null || clientname != null || clientemail != null) {
			
			responce.setResponseCode(0).setResponsemessage("success");
			
		}else {
			
			responce.setResponseCode(10).setResponsemessage("Failed");
			
			
		}
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();
	}

	
	
	

}
