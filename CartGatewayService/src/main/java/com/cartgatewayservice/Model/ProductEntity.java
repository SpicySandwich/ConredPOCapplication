package com.cartgatewayservice.Model;


import java.util.Arrays;
import java.util.List;
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
public class ProductEntity {
	
    private  Integer purchase_item;
    private String productname;
    private String productbrand;
    private Double productprice;
    private String productdescription;
    private Integer productquantity;
    private String productexpirationdate;

    

 
 public List<ProductEntity> testlist(Product  pBuilder){
	 
		return  Arrays.asList(ProductEntity.builder()
	  			.purchase_item( pBuilder.getPurchaseItem())
	  			.productname(pBuilder.getProductname())
	  			.productbrand(pBuilder.getProductbrand())
	  			.productprice(pBuilder.getProductprice())
	  			.productdescription(pBuilder.getProductdescription())
	  			.productquantity(pBuilder.getProductquantity())
	  			.productexpirationdate(pBuilder.getProductexpirationdate())
	  			.build()
	  			);
			
		
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
    public List<Product> GetProductList() {
    	ProductEntity productEntity = new ProductEntity();
        return List.of(
      		  Product.newBuilder()
      		  .setPurchaseItem(productEntity.getPurchase_item())
      		  .setProductname(productEntity.getProductname())
      		  .setProductbrand(productEntity.getProductbrand())
      		  .setProductprice(productEntity.getProductprice())
      		  .setProductdescription(productEntity.getProductdescription())
      		  .setProductquantity(productEntity.getProductquantity())
      		  .setProductexpirationdate(productEntity.getProductexpirationdate())
      		  .build()
      		  );
         
  	 }
    
    public static ProductEntity fromProto() {
    	Product pBuilder = Product.newBuilder().build();
    	ProductEntity productEntity = new ProductEntity();
    	
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
