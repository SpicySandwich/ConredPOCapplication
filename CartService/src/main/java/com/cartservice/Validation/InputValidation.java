package com.cartservice.Validation;

import com.cartservice.ConvertParameters.BodyConvertParametrs;
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
		    || bofBodyConvertParametrs.convertJavaDouble(request.getProductprice())== 0
		    || bofBodyConvertParametrs.convertJavaString(request.getProductdescription()).trim().isEmpty()
		    || bofBodyConvertParametrs.convertJavaInteger(request.getProductquantity())== 0
		    	) throw new NullPointerException();
		return request;
	
	}
	
	

}
