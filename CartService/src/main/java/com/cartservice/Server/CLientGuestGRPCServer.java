package com.cartservice.Server;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.Model.Client;
import com.cartservice.Service.GuestClientServiceImpl;
import com.cartservice.Validation.ClientGuestValidation;
import com.google.protobuf.Int32Value;
import com.grpcserver.ClientGuestGrpc.ClientGuestImplBase;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CLientGuestGRPCServer  extends ClientGuestImplBase{
	
@Autowired
private ClientGuestValidation clientGuestValidation;
	
@Autowired
private GuestClientServiceImpl guestClientServiceImpl;


private static final Logger log = LoggerFactory.getLogger(CLientGuestGRPCServer.class);

	@Override
	public void insert(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		
	Client client = new Client();
	APIResponse.Builder  responce = APIResponse.newBuilder();
	
		try {
			
			client.setClient_guest_id(request.getClientGuestId());
			client.setClient_guest_name(request.getClientGuestName());
			client.setClient_guest_email(request.getClientGuestEmail());

		
					guestClientServiceImpl.saveDataFromDTO(client);
					
					responce.setResponseCode(0).setResponsemessage("Succefull added to database " +client);
					
					responseObserver.onNext(responce.build());
					responseObserver.onCompleted();	
					
	
		}catch (DuplicateKeyException e) {
		
			clientGuestValidation.EmailValidation(client);
		}
//		
//		catch (Exception e) {
//			
//			clientGuestValidation.validation(client);
//			
//			
//		}
			
			
	}
	

	@Override
	public void update(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
		com.cartservice.Model.Client clientGuestRequest = new com.cartservice.Model.Client();
		
		clientGuestRequest.setClient_guest_id(request.getClientGuestId());
		clientGuestRequest.setClient_guest_name(request.getClientGuestName());
		clientGuestRequest.setClient_guest_email(request.getClientGuestEmail());
		
		
		guestClientServiceImpl.updatebyDTO(clientGuestRequest);

				
				APIResponse.Builder  responce = APIResponse.newBuilder();
					
				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();
		
	}
	


	@Override
	public void findAll(Empty request, StreamObserver<ClientGuestRequest> responseObserver) {
		List<ClientGuestDTO> list = guestClientServiceImpl.getClient();
		
	for(ClientGuestDTO client : list) {
		
		responseObserver.onNext(client.toGuest());
		
		
	}
	   responseObserver.onCompleted();
	}


	@Override
	public void findById(Int32Value request, StreamObserver<ClientGuestRequest> responseObserver) {
		

	try {
			
			ClientGuestDTO clientGuestRequest = guestClientServiceImpl.getDataByDTO( request.getValue());

			responseObserver.onNext(clientGuestRequest.toGuest());
			responseObserver.onCompleted();
			
		} catch (Exception e) {
		
			clientGuestValidation.validateID(request.getValue());	
			
		}					
	
	}

	@Override
	public void deleteById(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {

		APIResponse.Builder  responce = APIResponse.newBuilder();
			try {	
		guestClientServiceImpl.deleteDTO(request.getClientGuestId());
		
		
		} catch (Exception e) {
		
			responce.setResponseCode(100).setResponsemessage("Error");
			System.out.println("there is error");
			
		}finally {
			responce.setResponseCode(0).setResponsemessage("Succesfuly deleted");
			
		}
			
				responseObserver.onNext(responce.build());
				responseObserver.onCompleted();

	}
}
