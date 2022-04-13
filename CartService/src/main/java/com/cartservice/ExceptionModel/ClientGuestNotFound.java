package com.cartservice.ExceptionModel;

import com.grpcserver.GuestClientServer.ClientGuestErrorCode;

import lombok.Getter;


@Getter
public class ClientGuestNotFound extends RuntimeException{


	private static final long serialVersionUID = 5684046530985904633L;
	
	private ClientGuestErrorCode ErrorCode;

	public ClientGuestNotFound(ClientGuestErrorCode ErrorCode) {
		super(ErrorCode.name());
		this.ErrorCode = ErrorCode;
	}

	
}
