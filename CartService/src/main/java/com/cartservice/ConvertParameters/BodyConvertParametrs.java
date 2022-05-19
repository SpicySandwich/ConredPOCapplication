package com.cartservice.ConvertParameters;





import com.cartservice.DateProtoConvert.DateConvert;
import com.cartservice.Model.ProductEntity;
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
	
	public ProductEntity bodyData(Product request) {
		
        ProductEntity productEntity = new ProductEntity();
		
		productEntity.setPurchase_item(convertJavaInteger(request.getPurchaseItem()) );
		productEntity.setProductname(convertJavaString(request.getProductname()) );
		productEntity.setProductbrand(convertJavaString(request.getProductbrand())  );
		productEntity.setProductprice(convertJavaDouble(request.getProductprice()));
		productEntity.setProductdescription(convertJavaString(request.getProductdescription()) );
		productEntity.setProductquantity(convertJavaInteger(request.getProductquantity()) );
		productEntity.setProductexpirationdate(dateConvert.getDateFromDateProto(request.getProductexpirationdate()));
		
		return productEntity;
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
