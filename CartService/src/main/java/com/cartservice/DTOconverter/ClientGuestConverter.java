package com.cartservice.DTOconverter;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.Model.Client;


@Component
public class ClientGuestConverter {
	
	@Autowired
	private ModelMapper modelMapper;

	public ClientGuestDTO  convertToDto(Client userObject) {
		return modelMapper.map(userObject, ClientGuestDTO .class);
	}

}
