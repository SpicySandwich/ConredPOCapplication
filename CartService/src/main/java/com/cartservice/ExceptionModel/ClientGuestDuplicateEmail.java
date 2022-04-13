package com.cartservice.ExceptionModel;

import com.grpcserver.GuestClientServer.ClientGuestErrorCode;

import lombok.Getter;

@Getter
public class ClientGuestDuplicateEmail extends RuntimeException {

	private static final long serialVersionUID = 5393965998869450642L;
	
	private ClientGuestErrorCode clientGuestErrorCode;
	
	public ClientGuestDuplicateEmail(ClientGuestErrorCode clientGuestErrorCode) {
		super(clientGuestErrorCode.name());
		
		this.clientGuestErrorCode=clientGuestErrorCode;
	}

}
