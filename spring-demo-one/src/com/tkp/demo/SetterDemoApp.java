package com.tkp.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context  = 
				new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		MyCoach theCoach = context.getBean("myCoach2", MyCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFotune());
		
//		System.out.println(theCoach.getEmailAddress());
//		System.out.println(theCoach.getTeam());
		// close the context
		context.close();
	}

}
