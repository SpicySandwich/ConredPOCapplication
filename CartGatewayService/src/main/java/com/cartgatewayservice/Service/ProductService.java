package com.cartgatewayservice.Service;

import org.springframework.stereotype.Service;
import com.cartgatewayservice.Model.ProductEntity;
import com.google.protobuf.Int32Value;
import com.grpcserver.product.ProductServer.APIResponse;
import com.grpcserver.product.ProductServer.Product;
import com.grpcserver.product.ProductServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class ProductService {
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
            .usePlaintext()
            .build();
	
	public String inserdata(ProductEntity product) {
		
	
	ProductServiceGrpc.ProductServiceBlockingStub stub = ProductServiceGrpc.newBlockingStub(channel);
	APIResponse response = stub.insert(Product.newBuilder()
			.setPurchaseItem(product.getPurchase_item())
			.setProductname(product.getProductname())
			.setProductbrand(product.getProductbrand())
			.setProductprice(product.getProductprice())
			.setProductdescription(product.getProductdescription())
			.setProductquantity(product.getProductquantity())
		.setProductexpirationdate(product.getProductexpirationdate())
			.build());
	return response.getResponsemessage();
	


	}
	
	public ProductEntity findbyid(Integer purchase_item){
		
		ProductServiceGrpc.ProductServiceBlockingStub stub = ProductServiceGrpc.newBlockingStub(channel);
		
		ProductEntity productEntity = new ProductEntity();
		
		Product product = stub.findById(Int32Value.of(purchase_item));
		
		productEntity.setPurchase_item(product.getPurchaseItem());
		productEntity.setProductname(product.getProductname());
		productEntity.setProductbrand(product.getProductbrand());
		productEntity.setProductprice(product.getProductprice());
		productEntity.setProductdescription(product.getProductdescription());
		productEntity.setProductquantity(product.getProductquantity());
		productEntity.setProductexpirationdate(product.getProductexpirationdate());
			
		return productEntity;
	}
	
	public String deletedata(Integer client_guest_id) {

ProductServiceGrpc.ProductServiceBlockingStub stub = ProductServiceGrpc.newBlockingStub(channel);
		
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setPurchase_item(client_guest_id);
		
		
		APIResponse response = stub.deleteById(Product.newBuilder()
				.setPurchaseItem(productEntity.getPurchase_item())
				.build()
				);
		
		return response.getResponsemessage();
}
	
	public String updatedata(ProductEntity product) {

		ProductServiceGrpc.ProductServiceBlockingStub stub = ProductServiceGrpc.newBlockingStub(channel);
		
		APIResponse response = stub.update(Product.newBuilder()
				.setPurchaseItem(product.getPurchase_item())
				.setProductname(product.getProductname())
				.setProductbrand(product.getProductbrand())
				.setProductprice(product.getProductprice())
				.setProductdescription(product.getProductdescription())
				.setProductquantity(product.getProductquantity())
			.setProductexpirationdate(product.getProductexpirationdate())
				.build());
	
	return response.getResponsemessage();
			
	}

}
