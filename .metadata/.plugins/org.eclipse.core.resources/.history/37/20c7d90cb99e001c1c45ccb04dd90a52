package com.logactivity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.logactivity.Entity.LogsRecord;
import com.logactivity.Repository.LogsRepository;

@Component
public class Consumer {
	
	@Autowired
	LogsRepository logsRepository;
	
	@Autowired(required = false) 
	private LogsRecord record;
	
	//mongodb save consume  
	@KafkaListener(topics = "${topic.name}", containerFactory = "kafkaListenerContainerFactory")
	@Transactional
	  LogsRecord  listen(String alllogs){
		  record.setRecords(alllogs);
		  System.out.println("Message receive from producer to consumer : " + alllogs);
			return  logsRepository.save( record);

	    }
	  
	 
	  


}
