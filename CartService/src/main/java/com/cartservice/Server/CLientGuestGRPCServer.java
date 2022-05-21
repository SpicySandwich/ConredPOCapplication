package com.cartservice.Server;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.cartservice.ConvertParameters.BodyConvertParametrs;
import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.Model.Client;
import com.cartservice.Service.GuestClientServiceImpl;
import com.cartservice.Validation.ClientGuestValidation;
import com.google.protobuf.Int32Value;
import com.grpcserver.ClientGuestServiceGrpc.ClientGuestServiceImplBase;
import com.grpcserver.GuestClientServer.APIResponse;
import com.grpcserver.GuestClientServer.ClientGuest;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CLientGuestGRPCServer  extends ClientGuestServiceImplBase{
	//ClientGuestImplBase
	
@Autowired
private ClientGuestValidation clientGuestValidation;
	
@Autowired
private GuestClientServiceImpl guestClientServiceImpl;
 


@Autowired
private  BodyConvertParametrs bodyConvertParameters;



@Override
public void insert(ClientGuest request, StreamObserver<APIResponse> responseObserver) {
	
					guestClientServiceImpl.saveDataFromDTO(bodyConvertParameters.insertClient(request));
					APIResponse.Builder  responce = APIResponse.newBuilder();
					responce.setResponseCode(0).setResponsemessage("Succefull added to database ");
					responseObserver.onNext(responce.build());
					responseObserver.onCompleted();	
					
}

//
//@Override
//public void findById(Int32Value request, StreamObserver<ClientGuestRequest> responseObserver) {
//	
//		
//		ClientGuestDTO clientGuestRequest = guestClientServiceImpl.getDataByDTO( request.getValue());
//
//		responseObserver.onNext(clientGuestRequest.toGuest());
//		responseObserver.onCompleted();
//		
//	
//
//}
//

//	@Override
//	public void update(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
//		com.cartservice.Model.Client clientGuestRequest = new com.cartservice.Model.Client();
//		
//		clientGuestRequest.setClient_guest_id(request.getClientGuestId());
//		clientGuestRequest.setClient_guest_name(request.getClientGuestName());
//		clientGuestRequest.setClient_guest_email(request.getClientGuestEmail());
//		
//		
//		guestClientServiceImpl.updatebyDTO(clientGuestRequest);
//
//				
//				APIResponse.Builder  responce = APIResponse.newBuilder();
//					
//				responseObserver.onNext(responce.build());
//				responseObserver.onCompleted();
//		
//	}
//	
//
//
//	@Override
//	public void findAll(Empty request, StreamObserver<ClientGuestRequest> responseObserver) {
//		List<ClientGuestDTO> list = guestClientServiceImpl.getClient();
//		
//	for(ClientGuestDTO client : list) {
//		
//		responseObserver.onNext(client.toGuest());
//		
//		
//	}
//	   responseObserver.onCompleted();
//	}
//

//	@Override
//	public void deleteById(ClientGuestRequest request, StreamObserver<APIResponse> responseObserver) {
//
//		APIResponse.Builder  responce = APIResponse.newBuilder();
//		
//		guestClientServiceImpl.deleteDTO(request.getClientGuestId());
//		
//		
//			responce.setResponseCode(100).setResponsemessage("Error");
//			System.out.println("there is error");
//			
//
//			responce.setResponseCode(0).setResponsemessage("Succesfuly deleted");
//			
//
//				responseObserver.onNext(responce.build());
//				responseObserver.onCompleted();
//
//	}
}
