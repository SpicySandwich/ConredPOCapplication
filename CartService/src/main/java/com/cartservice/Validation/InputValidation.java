package com.cartservice.Validation;


import com.cartservice.ConvertParameters.BodyConvertParametrs;
import com.cartservice.ModelExceptionGRPC.NOT_NULL_GRPC;
import com.grpcserver.product.ProductServer.CartErrorCode;
import com.grpcserver.product.ProductServer.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputValidation {
	
	
	@Autowired
	private BodyConvertParametrs bofBodyConvertParametrs;
	
	public  Product nullErrors( Product  request){
		
	    if (
	    		bofBodyConvertParametrs.convertJavaString(request.getProductname()).trim().isEmpty()
		    || bofBodyConvertParametrs.convertJavaString(request.getProductbrand()).trim().isEmpty()
		    || bofBodyConvertParametrs.convertJavaString( request.getProductdescription()).trim().isEmpty()
		    	) throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL);
		return request;
	
	}
	public boolean isNullOrZeroDouble(Double i){
		
	     return i == null || i.doubleValue() == 0;
	}
	
	public boolean isNullOrZeroInterger(Integer i){
		boolean valid = true;
	   if (i == null || i.intValue() == 0) {
		   throw new NullPointerException();
	} else {
		return valid;
	}
	   
	   

	
	}
	

	

}
