package com.cartgatewayservice.Controller;

import java.util.List;

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
;



@RestController
public class ClientGuestController {

   
	@Autowired
	GRPCClientGuestService grpcClientGuestService;
 
	
     @PostMapping("/clientGuest")
     public String test2( @RequestBody ClientEntity clientEntity) {
      return  grpcClientGuestService.inserdata(clientEntity);
         
         
     }
     
     @DeleteMapping("/clientGuest/{client_guest_id}")
     public void DeleteClient(@PathVariable Integer client_guest_id, @RequestBody ClientEntity clientEntity) {
    	 
    grpcClientGuestService.deletedata(client_guest_id);
    
    	 
     }
     
     @PutMapping("/clientGuest")
     public String update(@RequestBody ClientEntity clientEntity){
    	 grpcClientGuestService.updatedata(clientEntity);
		return "Successfully update the product: " +clientEntity;
       
     }
     
     @GetMapping("/clientGuest/{client_guest_id}")
    	 public ClientEntity getGuestClientData(@PathVariable Integer client_guest_id, @RequestBody ClientEntity clientEntity) {
    	  grpcClientGuestService.findData(client_guest_id);
    	  return clientEntity;

    	 
     }
     
//     @GetMapping("/clientGuestList")
//     public List<ClientEntity> GetProductName(){
//           return grpcClientGuestService.getAllCLientData();
//           
//  	 }
     
     
 
    
     

     
    
}
