package com.cartservice.Validation;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartservice.ExceptionModel.ClientGuestDuplicateEmail;
import com.cartservice.ExceptionModel.ClientGuestNotFound;
import com.cartservice.ExceptionModel.ClientGuestNotNull;
import com.cartservice.Model.Client;
import com.cartservice.Service.GuestClientServiceImpl;
import com.grpcserver.GuestClientServer.ClientGuestErrorCode;

@Service
public class ClientGuestValidation {
	
	@Autowired
	private GuestClientServiceImpl guestClientServiceImpl;
	
	
	public void validation (Client client) {
		
	checkIfNull(client);
	
	
		
	}
	
//	public void EmailValidation(Client client) {
//		DuplicateEmail(client);
//	}
//	
	public void validateID(Integer client_guest_id) {
		
		NotFound(client_guest_id);
		
		
	}
	
	
	@SuppressWarnings("null")
	private void checkIfNull( Client client) {
		
		Optional<Client> cOptional = Optional.empty();
		
		if(cOptional.isEmpty()) {
			
			throw new ClientGuestNotNull(ClientGuestErrorCode.CLIENT_GUEST_VALUE_CANNOT_BE_NULL);
			
		}
		
	}
	
	private void NotFound(Integer client_guest_id ) {
		
		Optional<Client> cOptional =  Optional.empty();
		
		if(!cOptional.isPresent()) {
			throw new ClientGuestNotFound(ClientGuestErrorCode.CLIENT_GUEST_NOT_FOUND);
		}
		
		
	}
	
//	private void DuplicateEmail(Client client) {
//
//     String name = client.getClient_guest_email();
//		    	
//		    	if( guestClientServiceImpl.chechEmail(name)) {
//					
//					throw new ClientGuestDuplicateEmail(ClientGuestErrorCode.CLIENT_GUEST_EMAIL_DUPLICATE);
//				}
//	
//		
//	}

	
	
	
	

}
