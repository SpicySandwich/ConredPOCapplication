package com.cartservice.DTOconverter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cartservice.DTO.ProductDTO;
import com.cartservice.Model.ProductEntity;


@Component
public class ProductConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProductDTO  convertToDto(ProductEntity  userObject) {
		return modelMapper.map(userObject, ProductDTO .class);
	}
	
	

}
