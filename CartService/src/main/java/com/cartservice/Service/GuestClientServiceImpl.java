package com.cartservice.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.DAO.ClientDAO;
import com.cartservice.DTO.ClientGuestDTO;
import com.cartservice.Model.Client;


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
	
	public void deleteDTO(Integer client_guest_id) {
		
	 convertClientGuestDTOtoClient (clientDAO.deleteById(client_guest_id));
	}
	
	//DTO update
	
	public ClientGuestDTO updatebyDTO(Client client) {
		clientDAO.update(client);
	return convertClientGuestDTOtoClient( client);
		
	}


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
