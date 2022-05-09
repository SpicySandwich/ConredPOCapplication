package com.logactivity;


import com.logactivity.Entity.LogsRecord;
import com.logactivity.Repository.LogsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
	

	
	@Autowired
	private LogsRepository logsRepository;
	
	@PostMapping("/add")
	public String logsRecords(@RequestBody LogsRecord logsRecord) {
		
		 logsRepository.save(logsRecord);
			return "Succesfuly added" + logsRecord;
		
	}
	

	
	@GetMapping("/get")
	public String kogs () {
		
		return "Conred";
	}

}
