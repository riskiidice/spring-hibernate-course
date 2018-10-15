package com.example.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterThrowing(
			pointcut="execution(* com.example.demo.dao.AccountDAO.findAccount(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExc
			) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>Executing @AfterThrowing on method: "+method);
		System.out.println("\n====>>The Exception is : "+theExc);
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
		System.out.println("\n====>>Executing @AfterReturning on method: "+method);
		
		// print out the results of the method call 
		System.out.println("\n===>> result is : "+ result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to uppercase
		converAccountNamesToUpperCase(result);
		
		System.out.println("\n===>> result is : "+ result);
		
	}
	
	private void converAccountNamesToUpperCase(List<Account> result) {
		
		for (Account tempAccount : result) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
		
	}
	

	@Before("com.example.demo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\nExecuting=====> @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+ methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: "+ theAccount.getName());
				System.out.println("account level: "+ theAccount.getLevel());
			}
		}
				
	}
	

	
}
