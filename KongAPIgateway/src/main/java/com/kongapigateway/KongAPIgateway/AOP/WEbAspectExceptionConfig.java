//package com.kongapigateway.KongAPIgateway.AOP;
//
//import com.kongapigateway.KongAPIgateway.ModelException.DATE_FORMAT_ERROR;
//import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
//import com.kongapigateway.KongAPIgateway.ModelException.ProductIDnotFound;
//import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class WEbAspectExceptionConfig {
//	
//	 private Logger logger = LoggerFactory.getLogger(WEbAspectExceptionConfig.class);
//
//	    @ExceptionHandler(ProductValueNotNull.class)
//	    @ResponseStatus
//	    public void handle(ProductValueNotNull e) {
//	        logger.error(e.getMessage());
//	    }
//	    
//	    @ExceptionHandler(DATE_FORMAT_ERROR.class)
//	    @ResponseStatus
//	    public void handle2(DATE_FORMAT_ERROR e) {
//	    	   logger.error(e.getMessage());
//	    }
//	    
//	    @ExceptionHandler(ProductExecption.class)
//	    @ResponseStatus
//	    public void handle3(ProductExecption e) {
//	    	   logger.error(e.getMessage());
//	    }
//	    
//	    @ExceptionHandler(ProductIDnotFound.class)
//	    @ResponseStatus
//	    public void handle4(ProductIDnotFound e) {
//	    	   logger.error(e.getMessage());
//	    }
//	    
//	    
//
//}
