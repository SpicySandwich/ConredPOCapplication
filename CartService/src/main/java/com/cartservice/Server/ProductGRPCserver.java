package com.cartservice.Server;

import org.springframework.beans.factory.annotation.Autowired;

import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.DTO.ProductDTO;
import com.cartservice.Model.ProductEntity;
import com.cartservice.Service.ProductServiceImpl;
import com.google.protobuf.Int32Value;
import com.grpcserver.product.ProductServer.APIResponse;
import com.grpcserver.product.ProductServer.Empty;
import com.grpcserver.product.ProductServer.Product;
import com.grpcserver.product.ProductServiceGrpc.ProductServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductGRPCserver  extends ProductServiceImplBase{
	
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Override
	public void insert(Product request, StreamObserver<APIResponse> responseObserver) {
		com.cartservice.Model.ProductEntity productEntity = new com.cartservice.Model.ProductEntity();
		
		productEntity.setPurchase_item(request.getPurchaseItem());
		productEntity.setProductname(request.getProductname());
		productEntity.setProductbrand(request.getProductbrand());
		productEntity.setProductprice(request.getProductprice());
		productEntity.setProductdescription(request.getProductdescription());
		productEntity.setProductquantity(request.getProductquantity());
		productEntity.setProductexpirationdate(request.getProductexpirationdate());
		
		productServiceImpl.saveDataFromDTO(productEntity);
		
		APIResponse.Builder  responce = APIResponse.newBuilder();
		responce.setResponseCode(0).setResponsemessage("Succefull added to database " +productEntity);
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();	
	
	}

	@Override
	public void findAll(Empty request, StreamObserver<Product> responseObserver) {
		// TODO Auto-generated method stub
		super.findAll(request, responseObserver);
	}

	@Override
	public void deleteById(Product request, StreamObserver<APIResponse> responseObserver) {
	
		APIResponse.Builder  responce = APIResponse.newBuilder();
		
		productServiceImpl.deleteDTO(request.getPurchaseItem());
		
		responce.setResponseCode(0).setResponsemessage("Succesfuly deleted");
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();
	}

	@Override
	public void findById(Int32Value request, StreamObserver<Product> responseObserver) {
		
		ProductDTO productDTO = productServiceImpl.getDataByDTO(request.getValue());
		
		responseObserver.onNext(productDTO.toProduct());
	responseObserver.onCompleted();
		

	}

	@Override
	public void update(Product request, StreamObserver<APIResponse> responseObserver) {
	
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setPurchase_item(request.getPurchaseItem());
		productEntity.setProductname(request.getProductname());
		productEntity.setProductbrand(request.getProductbrand());
		productEntity.setProductprice(request.getProductprice());
		productEntity.setProductdescription(request.getProductdescription());
		productEntity.setProductquantity(request.getProductquantity());
		productEntity.setProductexpirationdate(request.getProductexpirationdate());
		
		productServiceImpl.updatebyDTO(productEntity);
		
		APIResponse.Builder  responce = APIResponse.newBuilder();
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();
		
	}
	
	

}
