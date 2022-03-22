package com.cartservice.Service;

import java.util.List;

import com.cartservice.Model.GuestClient;



public interface GuestClientService {
	
	
	List <GuestClient> getAll();

	GuestClient  getGuestClientInfo (Long clientid);

	void saveGuestClientInfo(GuestClient guestClient);

	void deleteGuestClientInfo (Long clientid);
	
	void updateGuestClientInfo (GuestClient guestClient);

}
