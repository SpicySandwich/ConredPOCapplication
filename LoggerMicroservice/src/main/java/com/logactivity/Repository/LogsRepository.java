package com.logactivity.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.logactivity.Entity.LogsRecord;

public interface LogsRepository extends MongoRepository<LogsRecord, String> {
	
	

}
