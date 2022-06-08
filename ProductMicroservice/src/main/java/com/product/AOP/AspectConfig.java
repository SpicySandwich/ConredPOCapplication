package com.product.AOP;



import com.product.KafkaProducer.ProductProducer;
import com.product.ModeException.DATE_FORMAT_EXCEPTION;
import com.product.ModeException.ProductExecption;
import com.product.ModeException.ProductIDnotFound;
import com.product.ModeException.ProductInternalError;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Configuration
@Order(1)
public class AspectConfig {
	
	@Autowired
	private ProductProducer productProducer;
	
private Logger log = LoggerFactory.getLogger(AspectConfig.class);
	
	@Around(value = "execution(* com.product.Controller.*.*(..))")
	  @Transactional
	public Object ErrorStatementAround(ProceedingJoinPoint point) throws Throwable {
		  Object result = null;
		try {
			result = point.proceed();	
		} catch (ProductExecption e) {
			log.info("Error result: {}",e.getMessage());
			productProducer.sendMessageDTO("ProductExecption Error : " +e.getMessage());
			throw new ProductExecption(e.getMessage());
			
			
		}catch (ProductIDnotFound e) {
			log.info("Error result: {}",e.getMessage());
			productProducer.sendMessageDTO("ProductIDnotFound Error: " +e.getMessage());
			throw new ProductIDnotFound(e.getMessage());
		
			
		}catch (DATE_FORMAT_EXCEPTION e) {
			log.info("Error result: {}",e.getMessage());
			productProducer.sendMessageDTO("DATE_FORMAT_EXCEPTION Error : " +e.getMessage());
			throw new DATE_FORMAT_EXCEPTION(e.getMessage());
			
		}catch (Exception e) {
			log.info("Error result: {}",e.getMessage());
			productProducer.sendMessageDTO("ProductInternalError Error : " +e.getMessage());
			throw new ProductInternalError(e.getMessage());

	}
		return result ;
	}

}
