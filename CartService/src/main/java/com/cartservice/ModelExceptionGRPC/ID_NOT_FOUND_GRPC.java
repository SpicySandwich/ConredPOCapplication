package com.cartservice.ModelExceptionGRPC;

import com.grpcserver.product.ProductServer.CartErrorCode;

import lombok.Getter;

@Getter
public class ID_NOT_FOUND_GRPC extends RuntimeException {
	
	
private static final long serialVersionUID = 5393965998869450642L;

private CartErrorCode cartErrorCode;

public ID_NOT_FOUND_GRPC(CartErrorCode cartErrorCode) {
	super(cartErrorCode.name());
	
	this.cartErrorCode=cartErrorCode;
}

}
