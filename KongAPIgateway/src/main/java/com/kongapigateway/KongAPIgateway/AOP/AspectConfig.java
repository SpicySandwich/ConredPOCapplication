package com.kongapigateway.KongAPIgateway.AOP;

import com.kongapigateway.KongAPIgateway.ModelException.DATE_FORMAT_ERROR;
import com.kongapigateway.KongAPIgateway.ModelException.ProductExecption;
import com.kongapigateway.KongAPIgateway.ModelException.ProductIDnotFound;
import com.kongapigateway.KongAPIgateway.ModelException.ProductValueNotNull;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Configuration
public class AspectConfig {
	
	private Logger log = LoggerFactory.getLogger(AspectConfig.class);
	
//	@Before(value = "execution(* com.kongapigateway.KongAPIgateway.Controller.*.*(..))")
//	public void controllerStatementBefore(JoinPoint joinPoint) {
//		
//		log.info("Executing {}",joinPoint);
//		
//	}
//	
//	@After(value = "execution(* com.kongapigateway.KongAPIgateway.Controller.*.*(..))")
//	public void controllerStatementAfter(JoinPoint joinPoint) {
//		log.info("Complete execution {}",joinPoint);
//		
//	}
	
	
	@Around(value = "execution(* com.kongapigateway.KongAPIgateway.Controller.*.*(..))")
	  @Transactional
	public Object ErrorStatementAround(ProceedingJoinPoint point) throws Throwable {
		  Object result = null;
		try {
			result = point.proceed();	
		} catch (DATE_FORMAT_ERROR e) {
			log.info("Error result: {}",e.getMessage());
			throw new DATE_FORMAT_ERROR(e.getMessage());
			
		}catch (ProductExecption e) {
			log.info("Error result: {}",e.getMessage());
			throw new ProductExecption(e.getMessage());
			
		}catch (ProductIDnotFound e) {
			log.info("Error result: {}",e.getMessage());
			throw new ProductIDnotFound(e.getMessage());
			
		}catch (ProductValueNotNull e) {
		log.info("Error result: {}",e.getMessage());
		throw new ProductValueNotNull(e.getMessage());
				
			}

		
		return result ;
		
	}

}
