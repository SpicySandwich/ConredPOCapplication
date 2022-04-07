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

import com.cartgatewayservice.Model.GuestClient;
import com.cartgatewayservice.Service.GRPCClientGuestService;
import com.grpcserver.GuestClientServer.ClientGuestRequest;
import com.grpcserver.GuestClientServer.ClientGuestRequestOutput;





@RestController
public class ClientGuestController {

   
	@Autowired
	GRPCClientGuestService grpcClientGuestService;
 
	
     @PostMapping("/clientGuest")
     public String addClient( @RequestBody GuestClient guestClient) {
      return  grpcClientGuestService.inserdata(guestClient);
         
         
     }
     
     @DeleteMapping("/clientGuest/{client_guest_id}")
     public void DeleteClient(@PathVariable Integer client_guest_id, @RequestBody GuestClient guestClient) {
    	 
    grpcClientGuestService.deletedata(client_guest_id);
    
    	 
     }
     
     @PutMapping("/clientGuest")
     public String update(@RequestBody GuestClient guestClient){
    	 grpcClientGuestService.updatedata(guestClient);
		return "Successfully update the product: " +guestClient;
       
     }
     
     @GetMapping("/clientGuest/{client_guest_id}")
    	 public GuestClient  getGuestClientData(@PathVariable Integer client_guest_id, @RequestBody GuestClient guestClient) {
              return grpcClientGuestService.findClient(client_guest_id);
            
    	 
     }

 
//      @GetMapping("/clientGuestListall")
//      public List<ClientEntity> GetProductName(){
//
//       return grpcClientGuestService.getProduct();
//             
//            
//     }

     


}
