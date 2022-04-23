package com.cartservice.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.DTO.ProductDTO;
import com.cartservice.Model.Client;
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
	
	public ProductDTO saveDataFromDTO(ProductEntity  productEntity) {
		
		
		
		productDAO.insert(productEntity);
		
		return convertProductDTOtoProduct(productEntity);
		
	}
	
	public ProductDTO getDataByDTO(Integer client_guest_id) {
		
		return convertProductDTOtoProduct(productDAO.findById(client_guest_id));
		
	}
	
public ProductDTO deleteDTO(Integer client_guest_id) {
		
		
	return convertProductDTOtoProduct(productDAO.deleteById(client_guest_id));
	}
public ProductDTO updatebyDTO(ProductEntity  productEntity) {
	productDAO.update(productEntity);
	return convertProductDTOtoProduct(productEntity);
	
}

}
