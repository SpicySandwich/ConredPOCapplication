package com.cartservice.DTO;


import java.util.List;

import com.grpcserver.product.ProductServer.Product;

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
    private String  productexpirationdate;

    
    public List<Product> GetProductList() {
    	ProductDTO productEntity = new ProductDTO();
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
    public List<Product> toProduct2(){
    	
    	return List.of( Product.newBuilder()
    			.setPurchaseItem(getPurchase_item())
    			.setProductname(getProductbrand())
    			.setProductbrand(getProductbrand())
    			.setProductprice(getProductprice())
    			.setProductdescription(getProductdescription())
    			.setProductquantity(getProductquantity())
    			.setProductexpirationdate(getProductexpirationdate())
    			.build());
    }  
    
    public Product toProduct(){
    	
    	return Product.newBuilder()
    			.setPurchaseItem(getPurchase_item())
    			.setProductname(getProductbrand())
    			.setProductbrand(getProductbrand())
    			.setProductprice(getProductprice())
    			.setProductdescription(getProductdescription())
    			.setProductquantity(getProductquantity())
    			.setProductexpirationdate(getProductexpirationdate())
    			.build();
    }
    
//    public ProductList toProductList() {
//    	
//    	List<Product> products = new ArrayList<Product>();
//    	
//    	return ProductList.newBuilder()
//    			.addAllProduct(products).build();
//    	
//    } 
    
   
    


}
