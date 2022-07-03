//package com.notification.TestControllerEmail;
//
//import com.notification.ServiceSendEmail.MailService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/mail")
//public class MailSendTestController {
//	
//	@Autowired
//	private MailService mailService;
//	
//	
//
//	@GetMapping
//	public String sendMessage(
//			
//			@RequestParam String Sender,
//			@RequestParam String Reciever,
//			@RequestParam String Subject,
//			@RequestParam String BodyEmail
//			) {
//		
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		simpleMailMessage.setFrom(Sender);
//		simpleMailMessage.setTo(Reciever);
//		simpleMailMessage.setSubject(Subject);
//		simpleMailMessage.setText(BodyEmail);
//		
//		mailService.sendMailtoUser(simpleMailMessage);
//		
//		return "Succefully sent to "+ Reciever;
//		
//	}
//
//}
