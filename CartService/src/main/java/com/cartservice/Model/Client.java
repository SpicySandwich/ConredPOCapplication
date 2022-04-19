package com.cartservice.Model;

import com.grpcserver.GuestClientServer.ClientGuestRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	private Integer client_guest_id;

	private String client_guest_name;
	private String client_guest_email;
	private Integer purchase_item;
	
	public int toDeleteTest() {
		
		return ClientGuestRequest.newBuilder()
				.getClientGuestId();
	
	}
	
	
	public ClientGuestRequest toGuest() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.setClientGuestName(getClient_guest_name())
				.setClientGuestEmail(getClient_guest_email())
				.setPurchaseItem(getPurchase_item())
				.build();
				
	}
	
	public ClientGuestRequest byID() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.build();
				
	}
	
	public static Client fromClient(ClientGuestRequest clientGuestRequest) {
		
		Client client = new Client();
		
		client.setClient_guest_id(clientGuestRequest.getClientGuestId());
		client.setClient_guest_name(clientGuestRequest.getClientGuestName());
		client.setClient_guest_email(clientGuestRequest.getClientGuestEmail());
		client.setClient_guest_id(clientGuestRequest.getClientGuestId());
		
		return client;
		
	}
	

}
