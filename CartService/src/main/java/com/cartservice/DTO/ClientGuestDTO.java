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

}
