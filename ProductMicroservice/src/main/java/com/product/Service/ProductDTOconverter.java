package com.product.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;

@Component
public class ProductDTOconverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProductDTO  convertToDto(Product userObject) {
		return modelMapper.map(userObject, ProductDTO .class);
	}

}
