package com.cartgatewayservice.AOP;




import com.cartgatewayservice.RestModelException.DATE_FORMAT_EXCEPTION;
import com.cartgatewayservice.RestModelException.ID_NOT_FOUND;
import com.cartgatewayservice.RestModelException.INTERNAL_ERROR;
import com.cartgatewayservice.RestModelException.NOT_NULL_EXCEPTION;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;


@Aspect
@Configuration
@Order(1)
public class AspectConfig {
	
	private Logger log = LoggerFactory.getLogger(AspectConfig.class);
	
	@Around(value = "execution(* com.cartgatewayservice.Controller.*.*(..))")
	  @Transactional
	public Object ErrorStatementAround(ProceedingJoinPoint point) throws Throwable {
		  Object result = null;
		try {
			result = point.proceed();	
		} catch (NOT_NULL_EXCEPTION e) {
			log.error("Error result: {}",e.getMessage());
			throw new NOT_NULL_EXCEPTION(e.getMessage());
			
		}catch (DATE_FORMAT_EXCEPTION e) {
			log.error("Error result: {}",e.getMessage());
			throw new DATE_FORMAT_EXCEPTION(e.getMessage());
			
		}catch (ID_NOT_FOUND e) {
			log.error("Error result: {}",e.getMessage());
			throw new ID_NOT_FOUND(e.getMessage());
			
		}catch (Throwable e) {
		log.error("Error result: {}",e.getMessage());
		throw new INTERNAL_ERROR(e.getMessage());
				
			}

		
		return result ;
		
	}

}
