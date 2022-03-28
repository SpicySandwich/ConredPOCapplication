package com.cartgatewayservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientGuestController {

   
	@Autowired
	GRPCClientGuestService grpcClientGuestService;

 
//     @GetMapping("/test")
//     public String test() {
//         return grpcClientGuestService.inserdata();
//     }
//     
	
     @PostMapping("/test")
     public String test2() {
      return  grpcClientGuestService.inserdata();
         
         
     }
     
    
}
