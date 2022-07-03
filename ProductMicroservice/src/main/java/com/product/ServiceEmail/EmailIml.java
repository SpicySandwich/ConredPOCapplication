package com.product.ServiceEmail;

import com.product.DTO.ProductDTO;
import com.product.Entity.EmailEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailIml {
	

	
	@Autowired
	  private MailSender mailSender;
	
	  public String sendEmail(ProductDTO productDTO) {
		  productDTO.getProductemail();
		  EmailEntity email = new EmailEntity();
		  email.setBody(productDTO.toString());
		  email.setReceiver(productDTO.getProductemail());
		  
	    return sendMessage(email);
	  }

	public String sendMessage(EmailEntity email) {
	    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	    simpleMailMessage.setFrom(email.getSender());
	    simpleMailMessage.setTo( email.getReceiver());
	    simpleMailMessage.setSubject(email.getSubject());
	    simpleMailMessage.setText(email.getBody());
	    mailSender.send(simpleMailMessage);
	    return "Email has been sent successfully.";
	  }
	
	public String transerToReceiver(String message) {
		return message;	
	}
	public String transerTobody(String message) {
		return message;
		
	}
	
	
}
