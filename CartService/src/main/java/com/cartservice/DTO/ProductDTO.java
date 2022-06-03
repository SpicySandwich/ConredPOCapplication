package com.cartservice.DTO;


import java.util.Calendar;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import com.grpcserver.product.ProductServer.Product;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private Integer purchase_item;
    private String productname;
    private String productbrand;
    private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private Date  productexpirationdate;

    
    public Product toProduct(){

    	return Product.newBuilder()
    			.setPurchaseItem(convertToint32value(getPurchase_item() ))
    			.setProductname(convertStringValue(getProductname()))
    			.setProductbrand(convertStringValue(getProductbrand()))
    			.setProductprice(convertDoubleValue(getProductprice()))
    			.setProductdescription(convertStringValue(getProductdescription()))
    			.setProductquantity(convertToint32value(getProductquantity()))
    			.setProductexpirationdate(getDateFromDateProto(getProductexpirationdate()))
    			.build();
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
    
    
	public static com.google.type.Date getDateFromDateProto(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		

		
		com.google.type.Date datess = com.google.type.Date.newBuilder().setYear(year).setMonth(month).setDay(day).build();
		
        return datess ;
    }
    

   
    


}
