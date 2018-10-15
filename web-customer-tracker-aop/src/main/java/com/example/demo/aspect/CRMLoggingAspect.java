package com.example.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// setup logger
	private Logger myLogger  = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for service and dao
	@Pointcut("execution(* com.example.demo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.example.demo.DAO.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage()  || forDAOPackage() ")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @Before: calling method: "+ theMethod);
		
		//display the arguments to the method
		
		// get the arguments 
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru arguments 
		for(Object tempArg : args) {
			myLogger.info("===> argument: "+tempArg);
		}
	}
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("===>> in @AfterReturning: calling method: "+ theMethod);
		
		myLogger.info("===>> theResult: "+ theResult);
	
	}
	
	// add @AfterReturning advice 
}
