package com.logactivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.logactivity.Entity.LogsRecord;
import com.logactivity.Repository.LogsRepository;


@RestController
public class testcontroller {
	
	
	@Autowired
	LogsRepository logsRepository;
	
	@PostMapping("/add")
	LogsRecord addDataTest(@RequestBody LogsRecord logsRecord) {
		
		return logsRepository.save(logsRecord);
	}

	
	@GetMapping
	public String test() {
		
		return "Hellow";
	}

}
