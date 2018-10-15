package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.DemoConfig;
import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;

@SpringBootApplication
public class SpringDemoAopApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringDemoAopApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO theMemberShipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount = new Account();
		
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doWork();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
	
		
		theMemberShipDAO.addAccount();
		theMemberShipDAO.goSleep();
		
		context.close();
	}
}
