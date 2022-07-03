package com.notification.EmailReceiver;


import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailReceiver {
	
	@SqsListener(value = "https://sqs.us-west-1.amazonaws.com/652912499006/producttopic_queue")
	public void MessageReceiver(String message) {
		log.info("Message receive: {}", message);
	}

}
