package com.cartgatewayservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientGuestController {

   
    GRPCClientGuestService grpcClientGuestService;

    
    @Autowired
    public ClientGuestController(GRPCClientGuestService grpcClientGuestService) {
        this.grpcClientGuestService = grpcClientGuestService;
    }



     @GetMapping("/test")
     public String test() {
         return grpcClientGuestService.test();
     }
     
     @PostMapping("/test")
     public String test2() {
         return grpcClientGuestService.test();
     }
    
}
