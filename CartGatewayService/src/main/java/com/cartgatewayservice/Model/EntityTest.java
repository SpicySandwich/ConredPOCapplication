package com.cartgatewayservice.Model;

import org.springframework.stereotype.Component;

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
@Component
public class EntityTest {
	
    private  Integer purchase_item;
    private String productname;
    private String productbrand;
    private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private String productexpirationdate;
    
    public EntityTest( Product product) {
    	
    	this.purchase_item=product.getPurchaseItem();
    	this.productname=product.getProductname();
    			this.productbrand=product.getProductbrand();
    			this.productprice=product.getProductprice();
    			this.productdescription=product.getProductdescription();
    			this.productquantity=product.getProductquantity();
    			this.productexpirationdate=product.getProductexpirationdate();	
    	
    }
    
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
    public static EntityTest fromProto(Product pBuilder) {
    	
    	EntityTest productEntity = new EntityTest();
    	
    	productEntity.setPurchase_item(pBuilder.getPurchaseItem());
    	productEntity.setProductname(pBuilder.getProductname());
    	productEntity.setProductbrand(pBuilder.getProductbrand());
    	productEntity.setProductprice(pBuilder.getProductprice());
    	productEntity.setProductdescription(pBuilder.getProductdescription());
    	productEntity.setProductquantity(pBuilder.getProductquantity());
    	productEntity.setProductexpirationdate(pBuilder.getProductexpirationdate());
		return productEntity ;
    	
    }
}
