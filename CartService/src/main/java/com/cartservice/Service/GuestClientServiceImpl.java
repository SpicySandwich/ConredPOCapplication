package com.cartservice.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.Model.Client;
import com.cartservice.Repository.ClientDAO;


@Service
public class GuestClientServiceImpl implements GuestClientService{
	
	@Autowired
	private  ClientDAO clientDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	private ClientGuestDTO convertClientGuestDTOtoClient (Client  client) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ClientGuestDTO clientdto = new ClientGuestDTO();
		clientdto = modelMapper.map(client, ClientGuestDTO.class);
		return clientdto;
		
	}
	
	//DTO List
	
	public List<ClientGuestDTO> getClient() {
		

			return clientDAO.findAll()
					.stream()
	                .map(this::convertClientGuestDTOtoClient)
	                .collect(Collectors.toList());	
	}
	//DTO add data
	
	public ClientGuestDTO saveDataFromDTO(Client client) {
		
		
		clientDAO.insert(client);
		
		return convertClientGuestDTOtoClient(client);
		
	}
	
	//DTO FindByID
	
	public ClientGuestDTO getDataByDTO(Integer client_guest_id) {
		
		return  convertClientGuestDTOtoClient(clientDAO.findById(client_guest_id));
	}
	
	//DTO Delete
	
	public ClientGuestDTO deleteDTO(Integer client_guest_id) {
		
		
		return   convertClientGuestDTOtoClient ( clientDAO.deleteById(client_guest_id));
	}
	
	//DTO update
	
	public ClientGuestDTO updatebyDTO(Client client) {
		clientDAO.update(client);
	return convertClientGuestDTOtoClient( client);
		
	}
	
	//Validate Duplicate Email
	
	public boolean chechEmail(String client_guest_email) {
		
		return clientDAO.checkEmailExists(client_guest_email);
		
    //convertClientGuestDTOtoClient(clientDAO.checkEmailExists(client_guest_email));
		
	}
	
	//test
	
//public void savewithProduct(Client client) {
//		
//		clientDAO.insert2(client);
//		
//	}
//	


	@Override
	public List<Client> getAll() {

		return clientDAO.findAll();
	}

	@Override
	public Client getGuestClientInfo(Integer client_guest_id) {
		
		return clientDAO.findById(client_guest_id);
	}

	@Override
	public void saveGuestClientInfo(Client client) {
		
		clientDAO.insert(client);
		
	}

	@Override
	public void deleteGuestClientInfo(Integer client_guest_id) {
	
		clientDAO.deleteById(client_guest_id);
	}

	@Override
	public void updateGuestClientInfo(Client client) {
	
		clientDAO.update(client);
		
	}




}
