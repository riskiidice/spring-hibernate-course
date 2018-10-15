package com.example.demo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.example.demo.service.*.getFortune(..))")
	 public Object aroundGetFortune(
			 ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
			 {
		
		// Print out method we are advising on
		 String method = theProceedingJoinPoint.getSignature().toShortString();
		 myLogger.info("\n=====>>> Executing @Around on method: "+method);
		 
		// Get begin timestamp
		long begin = System.currentTimeMillis();
		 
		// now, let's execute the method 
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();	
		}catch (Exception e) {
			// log exception
			myLogger.warning(e.getMessage());
//			// give user a custom message
//			result = "Major accident! But no worries, your private AOP helicopter is on the way! ";
			//rethrown
			throw e;
		}
		
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====>>>Duration: "+duration /1000.0 + "seconds");
		
		 return result;
	 }
	@After("execution(* com.example.demo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyAccountAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>Executing @After (Finally) method: "+method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.example.demo.dao.AccountDAO.findAccount(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExc
			) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>Executing @AfterThrowing on method: "+method);
		myLogger.info("\n====>>The Exception is : "+theExc);
	}
	@AfterReturning(
			pointcut="execution(* com.example.demo.dao.AccountDAO.findAccount(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result
			) {
		
		// Print out which method we are advertising
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>Executing @AfterReturning on method: "+method);
		
		// print out the results of the method call 
		myLogger.info("\n===>> result is : "+ result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to uppercase
		converAccountNamesToUpperCase(result);
		
		myLogger.info("\n===>> result is : "+ result);
		
	}
	
	private void converAccountNamesToUpperCase(List<Account> result) {
		
		for (Account tempAccount : result) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
		
	}
	

	@Before("com.example.demo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\nExecuting=====> @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+ methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: "+ theAccount.getName());
				myLogger.info("account level: "+ theAccount.getLevel());
			}
		}
				
	}
	

	
}
