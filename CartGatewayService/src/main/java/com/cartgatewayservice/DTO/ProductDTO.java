package com.cartgatewayservice.DTO;


import com.grpcserver.product.ProductServer.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {
	
	private  Integer purchase_item;
    private String productname;
    private String productbrand;
    private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private String productexpirationdate;
    
    
    
    public Product toProduct(){
    	
    	return Product.newBuilder()
    			.setPurchaseItem(getPurchase_item())
    			.setProductname(getProductname())
    			.setProductbrand(getProductbrand())
    			.setProductprice(getProductprice())
    			.setProductdescription(getProductdescription())
    			.setProductquantity(getProductquantity())
    			.setProductexpirationdate(getProductexpirationdate())
    			.build();
    }

}
