package com.product.ServiceEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	@Autowired
    private MailSender mailSender;
    

    
    public void sendMailMessage(SimpleMailMessage simpleMailMessage) {
         
         this.mailSender.send(simpleMailMessage);
     }

}
