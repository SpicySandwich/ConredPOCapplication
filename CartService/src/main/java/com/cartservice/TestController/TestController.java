package com.cartservice.TestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cartservice.Model.GuestClient;
import com.cartservice.Service.GuestClientServiceImpl;

@RestController
public class TestController {
	
	@Autowired 
	private GuestClientServiceImpl guestClientServiceImpl;
	
	  @GetMapping("/all")
	    public List<GuestClient> getAll() {
	        return guestClientServiceImpl.getAll();
	    }
	  
	  @PostMapping("/add")
	  public String addData(@RequestBody GuestClient guestClient) {
		  guestClientServiceImpl.saveGuestClientInfo(guestClient);
		  return "Succefully added";
	  }
	  @GetMapping("/view/{clientid}")
	     public GuestClient  GetClientInfo(@PathVariable Long clientid,@RequestBody  GuestClient guestClient){
		  return guestClientServiceImpl.getGuestClientInfo(clientid);
	   	
	     }
	  
	   @DeleteMapping("/delete/{clientid}")
	     public String DeteleClientData(@PathVariable Long clientid,@RequestBody GuestClient guestClient){
		   guestClientServiceImpl.deleteGuestClientInfo(clientid);
	           return "Succesfully deleted id:" +  clientid;

	     }
	   
	     @PutMapping("/update")
	     public String PutProduct(@RequestBody GuestClient guestClient){
	    	 guestClientServiceImpl.updateGuestClientInfo(guestClient);
			return "Successfully update the client: " + guestClient;
	       
	     }
	    

}
