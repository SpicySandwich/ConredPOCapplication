package com.cartservice.DTOconverter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cartservice.DTO.ProductDTO;
import com.cartservice.Model.ProductEntity;


@Component
public class ProductConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProductDTO  convertToDto(ProductEntity  productEntity) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProductDTO productDTO = new ProductDTO();
		productDTO =modelMapper.map(productEntity, ProductDTO .class);
		return productDTO;
	}
	
	

}
