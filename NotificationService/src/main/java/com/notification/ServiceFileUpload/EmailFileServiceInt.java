package com.notification.ServiceFileUpload;

import org.springframework.web.multipart.MultipartFile;

public interface EmailFileServiceInt {
	
	String sendFile(MultipartFile file);

}
