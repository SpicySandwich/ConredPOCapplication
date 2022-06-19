package com.cartservice.ConvertParameters;

import com.cartservice.DateProtoConvert.DateConvert;
import com.cartservice.Model.ProductEntity;
import com.cartservice.Validation.InputValidation;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import com.grpcserver.product.ProductServer.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyConvertParametrs {
	
	@Autowired
	private DateConvert dateConvert;
	
	@Autowired
	private  InputValidation inputValidation;
	


	public ProductEntity bodyData(Product request) {
		
      
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductname(convertJavaString(request.getProductname()));
        productEntity.setProductbrand(convertJavaString(request.getProductbrand()));
        productEntity.setProductprice(convertJavaDouble(request.getProductprice()));
        productEntity.setProductdescription(convertJavaString(request.getProductdescription()));
        productEntity.setProductquantity(convertJavaInteger(request.getProductquantity()));
        productEntity.setProductexpirationdate(dateConvert.getDateFromDateProto(request.getProductexpirationdate()));

  
		return productEntity;
	}
	
	public ProductEntity bodyDataUpdate(Product request) {
		
	      
        ProductEntity productEntity = new ProductEntity(
        		convertJavaInteger(request.getPurchaseItem()),
        		convertJavaString(request.getProductname()),
        		convertJavaString(request.getProductbrand()),
        		convertJavaDouble(request.getProductprice()),
        		convertJavaString(request.getProductdescription()),
        		convertJavaInteger(request.getProductquantity()),
        		dateConvert.getDateFromDateProto(request.getProductexpirationdate())
        		);
 
        
  
  
		return productEntity;
	}
	
	
	public Integer convertJavaInteger(Int32Value int32Value) {
	inputValidation.isNullOrZeroInterger(int32Value);
	Integer integer=(Integer)int32Value.getValue();
	return integer;
	}
	
	public String convertJavaString(StringValue stringValue) {
	inputValidation.isNullString(stringValue);
	String string = (String) stringValue.getValue();	
	return string;
	}
	
	public Double convertJavaDouble(DoubleValue doubleValue) {
	inputValidation.isNullOrZeroDouble(doubleValue);
	Double double1 = (Double) doubleValue.getValue();
	return double1;
	}
	


}
