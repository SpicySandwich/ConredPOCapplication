package com.notification.TestControllerEmail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping
	public String anyWord() {
		
		return "This is conred";
	}

}
