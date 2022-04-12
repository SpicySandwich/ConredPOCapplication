package com.cartservice.DTO;

import com.grpcserver.GuestClientServer.ClientGuestRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientGuestDTO {
	
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
	
	public ClientGuestDTO clientDTOtoGRPC(ClientGuestDTO clientGuestDTO) {
		
		ClientGuestRequest.Builder responce = ClientGuestRequest.newBuilder();
	
		
		clientGuestDTO .setClient_guest_id(responce.getClientGuestId());
		clientGuestDTO .setClient_guest_name(responce.getClientGuestName());
		clientGuestDTO .setClient_guest_email(responce.getClientGuestEmail());
		
		return clientGuestDTO;
		
	
	}
	
public Integer byID() {
	ClientGuestRequest.Builder responce = ClientGuestRequest.newBuilder();
 //responce.getClientGuestId();
		return responce.getClientGuestId() ;
				
	}
	
	


}
