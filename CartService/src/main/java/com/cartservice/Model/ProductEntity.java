package com.cartservice.Model;

import java.util.Date;

import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;

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
    private String   productexpirationdate;
    
//    public static Product  fromProduct(com.grpcserver.GuestClientServer.Product product) {
//    	Product product2 = new Product();
//    	product2.setPurchase_item(product.getPurchaseItem());
//    	product2.setProductname(product.getProductname());
//    	product2.setProductbrand(product.getProductbrand());
//    	product2.setProductprice(product.getProductprice());
//    	product2.setProductdescription(product.getProductdescription());
//    	product2.setProductcurrentdate(product.getProductcurrentdate());
//    	product2.setProductexpirationdate(product.getProductexpirationdate());
//    	
//    	return product2;
//    }
    

}
