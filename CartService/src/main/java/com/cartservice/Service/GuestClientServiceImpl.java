package com.cartservice.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.DAO.ClientDAO;
import com.cartservice.Model.Client;

@Service
public class GuestClientServiceImpl implements GuestClientService{
	
	@Autowired
	private  ClientDAO clientDAO;

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
