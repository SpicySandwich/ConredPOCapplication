package com.cartservice.Server;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.cartservice.ConvertParameters.BodyConvertParametrs;
import com.cartservice.DTO.ProductDTO;

import com.cartservice.Service.ProductServiceImpl;
import com.cartservice.Validation.InputValidation;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.grpcserver.product.ProductServer.APIResponse;
import com.grpcserver.product.ProductServer.Product;
import com.grpcserver.product.ProductServer.ProductList;
import com.grpcserver.product.ProductServiceGrpc.ProductServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductGRPCserver  extends ProductServiceImplBase{
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private BodyConvertParametrs  bodyConvertParametrs;
	
	@Autowired
	private InputValidation inputValidation;

	@Override
	public void insert(Product request, StreamObserver<APIResponse> responseObserver) {

		
		productServiceImpl.saveDataFromDTO(bodyConvertParametrs.bodyData(request));
		
		
	APIResponse.Builder  responce = APIResponse.newBuilder();
	responce.setResponseCode(0).setResponsemessage("Succefull added to database " );
	responseObserver.onNext(responce.build());
	responseObserver.onCompleted();	
		

	}
	

	@Override
	public void deleteById(Product request, StreamObserver<APIResponse> responseObserver) {

		productServiceImpl.chechIdExist(bodyConvertParametrs.convertJavaInteger( request.getPurchaseItem()));
		
		APIResponse.Builder  responce = APIResponse.newBuilder();
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
	
		productServiceImpl.updatebyDTO(bodyConvertParametrs.bodyDataUpdate(request));
		
		APIResponse.Builder  responce = APIResponse.newBuilder();
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();
		
	}



	@Override
	public void findAllRepeated(Product request, StreamObserver<ProductList> responseObserver) {
	
		List<ProductDTO> list = productServiceImpl.getAllPpoduct();
		
		List<Product> products = list.stream().map(ProductDTO::toProduct).collect(Collectors.toList());
		ProductList productList = ProductList.newBuilder().addAllProduct(products)
				.setResultCount(Int64Value.newBuilder().setValue(list.size()).build()).build();
		responseObserver.onNext(productList);
        responseObserver.onCompleted();
		
	}





}
