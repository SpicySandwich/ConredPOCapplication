package com.cartservice.ExceptionModel;

import com.grpcserver.GuestClientServer.ClientGuestErrorCode;

import lombok.Getter;

@Getter
public class ClientGuestNotNull extends RuntimeException{

	private static final long serialVersionUID = 3173039319542987759L;
	
	private ClientGuestErrorCode clientGuestErrorCode;
	
	public ClientGuestNotNull (ClientGuestErrorCode clientGuestErrorCode) {
		super(clientGuestErrorCode.name());
		this.clientGuestErrorCode = clientGuestErrorCode;
	}

}
