package com.product.ServiceEmail;

import java.text.MessageFormat;

import com.product.DTO.ProductDTO;
import com.product.Entity.EmailEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailIml {
	

	
	@Autowired
	  private MailSender mailSender;
	
	  public String sendEmail(ProductDTO productDTO) {
		  productDTO.getProductemail();
		  EmailEntity email = new EmailEntity();
		  
		  log.info(
				  "\nYou Hava Succesfully added the product."
						  + "\n\nProduct name: {}"
						  + "\nProduct Brand: {}"
						  +"\nProduct Price: {}"
						  +"\nProduct Description: {}"
						  +"\nProduct Quantity: {}",
						  productDTO.getProductname(),
						  productDTO.getProductbrand(),
						  productDTO.getProductprice(),
						  productDTO.getProductdescription(),
						  productDTO.getProductquantity(),
						  "\n\nThank you"
				  
				  );
		  String message =null;
	  if (log.isInfoEnabled()) {
		  message  = MessageFormat.format(
				  "\nYou Hava Succesfully added the product."
						  + "\n\nProduct name: {0}"
						  + "\nProduct Brand: {1}"
						  +"\nProduct Price: {2}"
						  +"\nProduct Description: {3}"
						  +"\nProduct Quantity: {4}",
						  productDTO.getProductname(),
						  productDTO.getProductbrand(),
						  productDTO.getProductprice(),
						  productDTO.getProductdescription(),
						  productDTO.getProductquantity(),
						  "\n\nThank you" ) ;
		  }
		  
		  email.setBody(message);
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
