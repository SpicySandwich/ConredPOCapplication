package com.cartgatewayservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartgatewayservice.Model.ClientEntity;
import com.cartgatewayservice.Service.GRPCClientGuestService;


@RestController
public class ClientGuestController {

   
	@Autowired
	GRPCClientGuestService grpcClientGuestService;
 
	
     @PostMapping("/test")
     public String test2( @RequestBody ClientEntity clientEntity) {
      return  grpcClientGuestService.inserdata(clientEntity);
         
         
     }
     
     @DeleteMapping("/test/{client_guest_id}")
     public void DeleteClient(@PathVariable Integer client_guest_id, @RequestBody ClientEntity clientEntity) {
    	 
    grpcClientGuestService.deletedata(client_guest_id);
    
    	 
     }
     
     @GetMapping("/test/{client_guest_id}")
    	 public ClientEntity getGuestClientData(@PathVariable Integer client_guest_id, @RequestBody ClientEntity clientEntity) {
    		 grpcClientGuestService.findData(client_guest_id);
			return clientEntity;

    	 
     }
     
     @PutMapping("/test")
     public String update(@RequestBody ClientEntity clientEntity){
    	 grpcClientGuestService.updatedata(clientEntity);
		return "Successfully update the product: " +clientEntity;
       
     }
    
     

     
    
}
