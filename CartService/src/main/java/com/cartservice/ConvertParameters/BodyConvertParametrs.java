package com.cartservice.ConvertParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.cartservice.DateProtoConvert.DateConvert;
import com.cartservice.Model.Client;
import com.cartservice.Model.ProductEntity;
import com.cartservice.Validation.InputValidation;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import com.grpcserver.GuestClientServer.ClientGuest;
import com.grpcserver.product.ProductServer.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyConvertParametrs {
	
	@Autowired
	private DateConvert dateConvert;
	
	@Autowired
	private  InputValidation inputValidation;
	
	public Client insertClient(ClientGuest clientGuest) {
		
		Client client = new Client();
		
	client.setClient_guest_id(convertJavaInteger(clientGuest.getClientGuestId()));
	client.setClient_guest_name(convertJavaString(clientGuest.getClientGuestName()));
	client.setClient_guest_email(convertJavaString(clientGuest.getClientGuestEmail()));
	client.setPurchase_item_cart(convertJavaList(clientGuest.getPurchaseItemCartList()));
		return client;
		
	}

	public ProductEntity bodyData(Product request) {
		
      
        ProductEntity productEntity = new ProductEntity(
        		convertJavaInteger(request.getPurchaseItem()),
        		convertJavaString(request.getProductname()),
        		convertJavaString(request.getProductbrand()),
        		convertJavaDouble(request.getProductprice()),
        		convertJavaString(request.getProductdescription()),
        		convertJavaInteger(request.getProductquantity()),
        		dateConvert.getDateFromDateProto(request.getProductexpirationdate())
        		);
        
        inputValidation.nullErrors(request);
  
		return productEntity;
	}
	
	public List< Integer> convertJavaList(List<Int32Value> list){
		
		List<Integer> list2 = new ArrayList<>();
		
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {	
			Int32Value int32Value2 = (Int32Value) iterator.next();
			
			Integer integers =(Integer)int32Value2.getValue();
			
			list2.add(integers);
		}

		return list2;
		
	}
	
	public Integer convertJavaInteger(Int32Value int32Value) {	
	Integer integer=(Integer)int32Value.getValue();
	return integer;
	}
	
	public String convertJavaString(StringValue stringValue) {
	String string = (String) stringValue.getValue();	
	return string;
	}
	
	public Double convertJavaDouble(DoubleValue doubleValue) {	
	Double double1 = (Double) doubleValue.getValue();
	return double1;
	}
	
    public DoubleValue convertDoubleValue(Double double1) {
    	return DoubleValue.of(double1);
    }
    
    public StringValue convertStringValue(String string) {
    	return StringValue.of(string);
 
    }
   
    public Int32Value convertToint32value(Integer integer) {
		return Int32Value.of(integer);
    	
    }
    


}
