package com.cartservice.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.DTO.ProductDTO;
import com.cartservice.Model.ProductEntity;
import com.cartservice.Repository.ProductDAO;

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
	if(productDAO.ifIDExist(productEntity.getPurchase_item()) == false) throw new NullPointerException();
	productDAO.update(productEntity);
	return convertProductDTOtoProduct(productEntity);
	
}
public boolean chechIdExist(Integer client_guest_id) {

	if (productDAO.ifIDExist(client_guest_id) == true) {
		return deleteDTO(client_guest_id);
	}else {
		throw new NullPointerException();
	}


}

//public boolean checkIdExistUpdate(Integer client_guest_id) {
//
//	ProductEntity  productEntity = new ProductEntity();
//	client_guest_id = productEntity.getPurchase_item();
//	
//	if (productDAO.ifIDExist(client_guest_id) == true) {
//		return 
//	}else {
//		throw new NullPointerException();
//	}
//
//
//}


}
