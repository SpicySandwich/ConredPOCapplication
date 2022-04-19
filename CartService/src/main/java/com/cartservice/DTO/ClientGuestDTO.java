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
	private Integer purchase_item;
	
	public ClientGuestRequest toGuest() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.setClientGuestName(getClient_guest_name())
				.setClientGuestEmail(getClient_guest_email())
				.setPurchaseItem(getPurchase_item())
				.build();
				
	}
	
	public int toDeleteTest() {
		
		return ClientGuestRequest.newBuilder()
				.getClientGuestId();
	
	}
	
	public ClientGuestRequest toDeleteID() {
		
		return ClientGuestRequest.newBuilder()
				.setClientGuestId(getClient_guest_id())
				.build();
				
	}
	
	public ClientGuestDTO clientDTOtoGRPC(ClientGuestDTO clientGuestDTO) {
		
		ClientGuestRequest.Builder responce = ClientGuestRequest.newBuilder();
	
		
		clientGuestDTO .setClient_guest_id(responce.getClientGuestId());
		clientGuestDTO .setClient_guest_name(responce.getClientGuestName());
		clientGuestDTO .setClient_guest_email(responce.getClientGuestEmail());
		clientGuestDTO.setClient_guest_id(responce.getClientGuestId());
		
		return clientGuestDTO;
		
	
	}
	
public Integer byID() {
	ClientGuestRequest.Builder responce = ClientGuestRequest.newBuilder();
 //responce.getClientGuestId();
		return responce.getClientGuestId() ;
				
	}


	
	


}
