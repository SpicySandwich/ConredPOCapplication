package com.notification.ServiceFileUpload;

import java.io.IOException;
import java.util.UUID;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AWSS3Service implements EmailFileServiceInt {

	
	@Autowired
	private AmazonS3Client awsS3Client;
	
	@Override
	public String sendFile(MultipartFile file) {
		
   String filename= StringUtils.getFilenameExtension(file.getOriginalFilename());
		
		String key = UUID.randomUUID().toString() + "." +filename;
		
		ObjectMetadata metaData = new ObjectMetadata();
		metaData.setContentLength(file.getSize());
		metaData.setContentType(file.getContentType());
		
		try {
			awsS3Client.putObject("pocstorages", key, file.getInputStream(), metaData);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while uploading the file");
		}
		
		awsS3Client.setObjectAcl("pocstorages", key, CannedAccessControlList.PublicRead);
		
		return awsS3Client.getResourceUrl("pocstorages", key);
	
	}

}
