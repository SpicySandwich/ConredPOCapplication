package com.cartgatewayservice.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartgatewayservice.BodyConvertParameters.ConvertParameters;
import com.cartgatewayservice.DTO.ProductDTO;
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
	private ConvertParameters convertParameters;
	
	
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
	private ProductDTO convertProductDTOtoProduct (ProductEntity  productEntity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(productEntity, ProductDTO.class);
		return productdto;
		
	}	
	
    
	private ProductDTO convertProductDTOtoProduct2 (String  productEntity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(productEntity, ProductDTO.class);
		return productdto;
		
	}	
    
	  public ProductService() {
	        initializeStub();
	    }
	  
	
	public ProductDTO inserdata(ProductEntity product) {
		
		ProductDTO productDTO = convertProductDTOtoProduct(product);
	APIResponse response = productServiceBlockingStub.insert( convertParameters.InsertbodyData(productDTO));
	convertParameters.convertStringValue(product.getProductname());	
	 response.getResponsemessage();
	
	 return productDTO;
	}
	

	
	public ProductDTO findbyid(Integer purchase_item){
		Product product = productServiceBlockingStub.findById(Int32Value.of(purchase_item));
		ProductEntity  productEntity =  convertParameters.FindbodyData(product);
		ProductDTO productDTO = convertProductDTOtoProduct(productEntity);
	return productDTO;
		
	}
	
	public void  deletedata(Integer client_guest_id) {
		ProductEntity productEntity = new ProductEntity();
		ProductDTO productDTO = convertProductDTOtoProduct(productEntity );
		productDTO.setPurchase_item(client_guest_id);
		APIResponse response = productServiceBlockingStub.deleteById(Product.newBuilder()
				.setPurchaseItem(convertParameters.convertToint32value(productDTO .getPurchase_item()) )
				.build()
				);
	response.getResponsemessage();
	
}
	
	public ProductDTO updatedata(ProductEntity product) {
		ProductDTO productDTO = convertProductDTOtoProduct(product);
		APIResponse response = productServiceBlockingStub.update( convertParameters.updatebodyData(productDTO));
	 response.getResponsemessage();
	 return productDTO;
	
	}

public List<ProductDTO> list(){

	 Product pBuilder = Product.newBuilder().build();
	ProductList productList =	productServiceBlockingStub.findAllRepeated(pBuilder);
	 List<Product> products2 = productList.getProductList();
 
	 List<ProductDTO> list = new ArrayList<>();
		for (Iterator iterator = products2.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			
			 ProductEntity productEntity2 = convertParameters.forList(product);
			 ProductDTO productDTO = convertProductDTOtoProduct(productEntity2);
			 list.add(productDTO);
			 	
		}
		
		 return list;
		
}

}
