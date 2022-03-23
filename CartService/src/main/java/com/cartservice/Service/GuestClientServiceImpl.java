package com.cartservice.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.DAO.GuestClientRepo;
import com.cartservice.Model.GuestClient;

@Service
public class GuestClientServiceImpl implements GuestClientService{
	
	@Autowired
	private  GuestClientRepo guestClientRepo;

	@Override
	public List<GuestClient> getAll() {
		return guestClientRepo.findAll();
	}

	@Override
	public GuestClient getGuestClientInfo(Long clientid) {
		return guestClientRepo.findById(clientid);
	
	}

	@Override
	public void saveGuestClientInfo(GuestClient guestClient) {
		guestClientRepo.insert(guestClient);
	}

	@Override
	public void deleteGuestClientInfo(Long clientid) {
		 guestClientRepo.deleteById(clientid);	
	}

	@Override
	public void updateGuestClientInfo(GuestClient guestClient) {
		guestClientRepo.update(guestClient);
	
		
	}

	
	
	

}
