package com.cartservice.ModelExceptionGRPC;

import com.grpcserver.product.ProductServer.CartErrorCode;

import lombok.Getter;

@Getter
public class ID_NOT_FOUND_GRPC extends RuntimeException {
	
	
private static final long serialVersionUID = 5393965998869450642L;

private CartErrorCode cartErrorCode;
private String message;

public ID_NOT_FOUND_GRPC(CartErrorCode cartErrorCode, String message) {
	super(cartErrorCode.name());
	
	this.cartErrorCode=cartErrorCode;
	this.message=message;
}

}
