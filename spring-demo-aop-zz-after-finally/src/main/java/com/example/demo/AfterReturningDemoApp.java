package com.example.demo;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.DemoConfig;
import com.example.demo.dao.AccountDAO;

@SpringBootApplication
public class AfterReturningDemoApp {

	public static void main(String[] args) {
//		SpringApplication.run(SpringDemoAopApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		List<Account> theAccounts = theAccountDAO.findAccount(false);
		
		System.out.println("\n\n Main Program: AfterThrowingDemoApp");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		context.close();
	}
}
