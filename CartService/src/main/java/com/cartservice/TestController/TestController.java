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
import com.cartservice.DAO.GuestClientRepo;
import com.cartservice.Model.GuestClient;

@RestController
public class TestController {
	
	@Autowired 
	private GuestClientRepo guestClientRepo;
	
	  @GetMapping("/all")
	    public List<GuestClient> getAll() {
	        return guestClientRepo.findAll();
	    }
	  
	  @PostMapping("/add")
	  public String addData(@RequestBody GuestClient guestClient) {
		  guestClientRepo.insert(guestClient);
		  return "Succefully added";
	  }
	  @GetMapping("/view/{clientid}")
	     public GuestClient  GetClientInfo(@PathVariable Long clientid,@RequestBody  GuestClient guestClient){
		  return   guestClientRepo.findById(clientid);
	   	
	     }
	  
	   @DeleteMapping("/delete/{clientid}")
	     public String DeteleClientData(@PathVariable Long clientid,@RequestBody GuestClient guestClient){
		   guestClientRepo.deleteById(clientid);
	           return "Succesfully deleted id:" +  clientid;


	     }
	   
	     @PutMapping("/update")
	     public String PutProduct(@RequestBody GuestClient guestClient){
	    	 guestClientRepo.update(guestClient);
			return "Successfully update the client: " + guestClient;
	       
	     }
	    

}
