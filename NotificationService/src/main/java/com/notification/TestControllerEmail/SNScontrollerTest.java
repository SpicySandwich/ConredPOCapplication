package com.notification.TestControllerEmail;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNScontrollerTest {
	
	@Autowired
	private AmazonSNSClient amazonSNSClient;
	
	
	@GetMapping("/sqs")
	public String subs() {
		SubscribeRequest subscribeRequest = new SubscribeRequest(
				"arn:aws:sns:us-west-1:652912499006:producttopic",
				"sqs",
				"arn:aws:sqs:us-west-1:652912499006:producttopic_queue"
				);
		amazonSNSClient.subscribe(subscribeRequest);
		
		return "SQS Subs";
		
	}
	@GetMapping("/message")
	public String sendmessage(@RequestParam String message) {
            PublishRequest publishRequest = new  PublishRequest(
				"arn:aws:sns:us-west-1:652912499006:producttopic",
				message,
				"POC Application"
				);
		
		amazonSNSClient.publish(publishRequest);
		
		return "SNS sent message";
	}
	
	@GetMapping("/email/{email}")
	public String subsEmail(@PathVariable(value = "email") String email) {
		SubscribeRequest subscribeRequest = new SubscribeRequest(
				"arn:aws:sns:us-west-1:652912499006:producttopic",
				"email",
				email
				);
		amazonSNSClient.subscribe(subscribeRequest);
		
		return "email Subs";
		
	}

}
