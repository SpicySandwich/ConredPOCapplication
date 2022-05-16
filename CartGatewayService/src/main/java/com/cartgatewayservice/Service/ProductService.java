package com.cartgatewayservice.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartgatewayservice.DTO.ProductDTO;
import com.cartgatewayservice.DateConverter.DateConvert;
import com.cartgatewayservice.Model.ProductEntity;
import com.google.protobuf.Int32Value;
import com.grpcserver.product.ProductServer.APIResponse;
import com.grpcserver.product.ProductServer.Product;
import com.grpcserver.product.ProductServer.ProductList;
import com.grpcserver.product.ProductServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


@Service
public class ProductService   {
	
	@Autowired
	private DateConvert dateConvert;
	
	
	 private ManagedChannel channel;
	 private  ProductServiceGrpc.ProductServiceStub productServiceStub;
	 private ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

	 
    private void initializeStub() {
        channel = ManagedChannelBuilder.forAddress("cartservice", 9090).usePlaintext().build();
        productServiceBlockingStub = ProductServiceGrpc.newBlockingStub(channel);
        productServiceStub = ProductServiceGrpc.newStub(channel);
    }
    
    @Autowired
	private ModelMapper modelMapper;
	
	private ProductDTO convertProductDTOtoProduct (String  productEntity) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(productEntity, ProductDTO.class);
		return productdto;
		
	}	
    
	  public ProductService() {
	        initializeStub();
	    }
	  
	
	public ProductEntity inserdata(ProductEntity product) {
		
	
	APIResponse response = productServiceBlockingStub.insert(Product.newBuilder()
			.setPurchaseItem(product.getPurchase_item())
			.setProductname(product.getProductname())
			.setProductbrand(product.getProductbrand())
			.setProductprice(product.getProductprice())
			.setProductdescription(product.getProductdescription())
			.setProductquantity(product.getProductquantity())
		.setProductexpirationdate(dateConvert.getDateFromDateProtoEntity(product.getProductexpirationdate()) )
			.build());
	 response.getResponsemessage();
	
	 return product;
	}
	

	
	public ProductEntity findbyid(Integer purchase_item){
		
		
		ProductEntity productEntity = new ProductEntity();
		
		Product product = productServiceBlockingStub.findById(Int32Value.of(purchase_item));
		
		productEntity.setPurchase_item(product.getPurchaseItem());
		productEntity.setProductname(product.getProductname());
		productEntity.setProductbrand(product.getProductbrand());
		productEntity.setProductprice(product.getProductprice());
		productEntity.setProductdescription(product.getProductdescription());
		productEntity.setProductquantity(product.getProductquantity());
		productEntity.setProductexpirationdate(dateConvert.getDateFromDateProto(product.getProductexpirationdate()));
			
		return productEntity;
	}
	
	public void  deletedata(Integer client_guest_id) {

		
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setPurchase_item(client_guest_id);
		
		
		APIResponse response = productServiceBlockingStub.deleteById(Product.newBuilder()
				.setPurchaseItem(productEntity.getPurchase_item())
				.build()
				);
	convertProductDTOtoProduct(response.getResponsemessage());
	
}
	
	public String updatedata(ProductEntity product) {

		APIResponse response = productServiceBlockingStub.update(Product.newBuilder()
				.setPurchaseItem(product.getPurchase_item())
				.setProductname(product.getProductname())
				.setProductbrand(product.getProductbrand())
				.setProductprice(product.getProductprice())
				.setProductdescription(product.getProductdescription())
				.setProductquantity(product.getProductquantity())
			.setProductexpirationdate(dateConvert.getDateFromDateProtoForUpdate(product.getProductexpirationdate()))
				.build());
	
	return response.getResponsemessage();
			
	
	}
	



public List<ProductEntity> list(){

	 Product pBuilder = Product.newBuilder().build();
	ProductList productList =	productServiceBlockingStub.findAllRepeated(pBuilder);
	 List<Product> products2 = productList.getProductList();
 
	 List<ProductEntity> list = new ArrayList<>();
		for (Iterator iterator = products2.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			
			 ProductEntity productEntity2 = (ProductEntity.builder()
			  			.purchase_item( product.getPurchaseItem())
			  			.productname(product.getProductname())
			  			.productbrand(product.getProductbrand())
			  			.productprice(product.getProductprice())
			  			.productdescription(product.getProductdescription())
			  			.productquantity(product.getProductquantity())
			  			.productexpirationdate(dateConvert.getDateFromDateProto(product.getProductexpirationdate()) )
			  			.build()
			  			);
				
			 list.add(productEntity2);
			 	
		}
		
		 return list;
		
}

}
