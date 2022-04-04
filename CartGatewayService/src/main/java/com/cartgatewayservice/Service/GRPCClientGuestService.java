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
import com.grpcserver.GuestClientServer.ClientGuestRequestOutput;
import com.grpcserver.GuestClientServer.ClientGuestrList;
import com.grpcserver.GuestClientServer.ClientGuestrListOrBuilder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


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
	

	
	public List<ClientEntity> getProduct() {
		ClientEntity clientEntity = new ClientEntity();
		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);
		ClientGuestRequest.Builder responce = ClientGuestRequest.newBuilder();

		

		ClientGuestRequest clientGuestRequest = stub.allinOne(responce.build());

		Integer clientid = clientGuestRequest.getClientGuestId();
		String clientname =  clientGuestRequest.getClientGuestName();
		String clientemail = clientGuestRequest.getClientGuestEmail();

		clientEntity.setClient_guest_id(clientid );
		clientEntity.setClient_guest_name(clientname);
		clientEntity.setClient_guest_email(clientemail);

	
		List<ClientEntity> newUnmodList = Arrays.asList( clientEntity);
	

			return  newUnmodList;
			
	}

	public List<ClientEntity> getProducts() {
		ClientEntity clientEntity = new ClientEntity();
		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

		ClientGuestRequest responce = ClientGuestRequest.newBuilder()
		.setClientGuestId(clientEntity.getClient_guest_id())
		.setClientGuestName(clientEntity.getClient_guest_name())
		.setClientGuestEmail(clientEntity.getClient_guest_email())
		.build();
		
	
	ClientGuestRequest clientGuestRequest = stub.allinOne(responce.toBuilder()
	.setClientGuestId(clientEntity.getClient_guest_id())
	.setClientGuestName(clientEntity.getClient_guest_name())
	.setClientGuestEmail(clientEntity.getClient_guest_email())
	.build());

		
		
		clientEntity.setClient_guest_id(clientGuestRequest.getClientGuestId());
		clientEntity.setClient_guest_name(clientGuestRequest.getClientGuestName());
		clientEntity.setClient_guest_email(clientGuestRequest.getClientGuestEmail());
		
		
		List<ClientEntity> newUnmodList = Arrays.asList( clientEntity);
	

			return  newUnmodList;
			
	}

	public List<ClientGuestRequest> findalls(ClientGuestRequestOutput clientGuestRequestOutput){

		

		ClientGuestGrpc.ClientGuestBlockingStub stub = ClientGuestGrpc.newBlockingStub(channel);

		Iterator<ClientGuestrList> clientGuestrList = stub.findAllByFilter(clientGuestRequestOutput);

	

		return ((ClientGuestrListOrBuilder) clientGuestrList).getClientguestallList();
	}






	// public void clientStreamingSumTest() throws InterruptedException {

    //     // pass the output stream observer & receive the input stream observer
    //     StreamObserver<Input> inputStreamObserver = this.clientStub.sumAll(new OutputStreamObserver());

    //     for (int i = 0; i <= 100; i++) {
    //         // build the request object
    //         Input input = Input.newBuilder()
    //                 .setNumber(i)
    //                 .build();
    //         // pass the request object via input stream observer
    //         inputStreamObserver.onNext(input);
    //     }

    //     // client side is done. this method makes the server respond with the sum value
    //     inputStreamObserver.onCompleted();

    // }








	
}
