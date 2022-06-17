package com.cartservice.AOP;


import com.cartservice.ModelExceptionGRPC.DATE_EXCEPTION_GRPC;
import com.cartservice.ModelExceptionGRPC.ID_NOT_FOUND_GRPC;
import com.cartservice.ModelExceptionGRPC.INTERNAL_ERROR_GRPC;
import com.cartservice.ModelExceptionGRPC.NOT_NULL_GRPC;
import com.grpcserver.product.ProductServer.CartErrorCode;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class AspectConfig {
	
	@Around(value = "execution(* com.cartservice.Server.*.*(..))")
	  @Transactional
	public Object ErrorStatementAround(ProceedingJoinPoint point) throws Throwable {
		  Object result = null;
		try {
			result = point.proceed();	
		} catch (DATE_EXCEPTION_GRPC e) {
			log.error("Error result: {}",e.getMessage());
			throw new DATE_EXCEPTION_GRPC(CartErrorCode.CART_DATE_ERROR, e.getMessage());
			
		}catch (ID_NOT_FOUND_GRPC e) {
			log.error("Error result: {}",e.getMessage());
			throw new ID_NOT_FOUND_GRPC(CartErrorCode.CART_ID_NOT_FOUND, e.getMessage());
			
		}catch (NOT_NULL_GRPC e) {
			log.error("Error result: {}",e.getMessage());
			throw new NOT_NULL_GRPC(CartErrorCode.CART_VALUE_CANNOT_BE_NULL, e.getMessage());
			
		}catch (Throwable e) {
		log.error("Error result: {}",e.getMessage());
		throw new INTERNAL_ERROR_GRPC(CartErrorCode.CART_INTERNAL_ERROR, e.getMessage());
				
			}

		
		return result ;
		
	}


}
