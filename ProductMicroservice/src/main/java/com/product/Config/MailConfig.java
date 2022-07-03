package com.product.Config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

import io.awspring.cloud.ses.SimpleEmailServiceMailSender;

@Configuration
public class MailConfig {
	
	  @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecretKey;

    @Value("${cloud.aws.region.static}")
    private String regionName;

	
	@Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {

		final BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecretKey);
		
      AmazonSimpleEmailService amazonSimpleEmailService = AmazonSimpleEmailServiceClientBuilder
    		  .standard()
          .withCredentials(new AWSStaticCredentialsProvider(credentials))
          .withRegion(regionName)
          .build();
      
      
      return amazonSimpleEmailService;
    }
	
	 @Bean
	  public MailSender mailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
	    return new SimpleEmailServiceMailSender(amazonSimpleEmailService);
	  }
    

}
