package com.cartservice.Model;


import java.util.Calendar;
import java.util.Date;

import com.grpcserver.product.ProductServer.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	
	private Integer purchase_item;
    private String productname;
    private String productbrand;
    private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private Date  productexpirationdate;
    
    public Product toProduct(){

    	return Product.newBuilder()
    			.setPurchaseItem(getPurchase_item())
    			.setProductname(getProductbrand())
    			.setProductbrand(getProductbrand())
    			.setProductprice(getProductprice())
    			.setProductdescription(getProductdescription())
    			.setProductquantity(getProductquantity())
    			.setProductexpirationdate(getDateFromDateProto(getProductexpirationdate()))
    			.build();
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
