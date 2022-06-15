package com.cartservice.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.DTO.ProductDTO;
import com.cartservice.Model.ProductEntity;
import com.cartservice.ModelExceptionGRPC.ID_NOT_FOUND_GRPC;
import com.cartservice.Repository.ProductDAO;
import com.grpcserver.product.ProductServer.CartErrorCode;

@Service
public class ProductServiceImpl {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private ProductDTO convertProductDTOtoProduct (ProductEntity  productEntity) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productdto = new ProductDTO();
		productdto = modelMapper.map(productEntity, ProductDTO.class);
		return productdto;
		
	}	
	
	public List<ProductDTO> getAllPpoduct() {
		

		return productDAO.findAll()
				.stream()
                .map(this::convertProductDTOtoProduct)
                .collect(Collectors.toList());	
}
	
	public ProductDTO saveDataFromDTO(ProductEntity  productEntity) {
		productDAO.insert(productEntity);
		return convertProductDTOtoProduct(productEntity);
		
	}
	
	public ProductDTO getDataByDTO(Integer client_guest_id) {
		
		return convertProductDTOtoProduct(productDAO.findById(client_guest_id));
		
	}
	
public  boolean deleteDTO(Integer client_guest_id) {
	
	productDAO.deleteById(client_guest_id);
	return true;
	}
public ProductDTO updatebyDTO(ProductEntity  productEntity) {
	if(productDAO.ifIDExist(productEntity.getPurchase_item()) == false) throw new ID_NOT_FOUND_GRPC(CartErrorCode.CART_ID_NOT_FOUND);
	productDAO.update(productEntity);
	return convertProductDTOtoProduct(productEntity);
	
}
public boolean chechIdExist(Integer client_guest_id) {

	if (productDAO.ifIDExist(client_guest_id) == true) {
		return deleteDTO(client_guest_id);
	}else {
		throw new ID_NOT_FOUND_GRPC( CartErrorCode.CART_ID_NOT_FOUND);
	}


}



}
