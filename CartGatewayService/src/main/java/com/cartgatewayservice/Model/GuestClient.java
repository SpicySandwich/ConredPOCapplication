package com.cartgatewayservice.Model;

import java.util.List;

import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.ClientGuestrList;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GuestClient {
	
	private Integer client_guest_id;
	private String client_guest_name;
	private String client_guest_email;

	

	public ClientGuestRequest toGuest() {

		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.setClientGuestName(getClient_guest_name())
				.setClientGuestEmail(getClient_guest_email())
			
				.build();
				
	}

	public List<ClientGuestRequest> findThe(GuestClient clientGuestRequest){

		return ClientGuestrList.newBuilder().getClientguestallList();
	}

	public GuestClient fromClient() {

		ClientGuestRequest.Builder clientGuestRequest = ClientGuestRequest.newBuilder();
		GuestClient client = new GuestClient();
		
		client.setClient_guest_id(clientGuestRequest.getClientGuestId());
		client.setClient_guest_name(clientGuestRequest.getClientGuestName());
		client.setClient_guest_email(clientGuestRequest.getClientGuestEmail());

		
		return client;
		
	}
	
	public ClientGuestRequest toDeleteID() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.build();
				
	}

}
