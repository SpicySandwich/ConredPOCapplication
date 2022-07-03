package com.notification.Config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SNSconfig {
	
	@Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecretKey;

    @Value("${cloud.aws.region.static}")
    private String regionName;
    
    
    @Bean
    @Primary
    public AmazonSNSClient amazonSNSClient() {
    	
    	BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecretKey);
    	
    	return (AmazonSNSClient) AmazonSNSClientBuilder
    			.standard()
    			.withRegion(regionName)
    			.withCredentials(new AWSStaticCredentialsProvider( credentials))
    			.build();
    	
    }
    

}
