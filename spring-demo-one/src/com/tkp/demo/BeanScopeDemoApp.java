package com.tkp.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class );
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class );
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\n same object: "+result);
		
		System.out.println("\n Memory location for theCoach: "+theCoach);
		
		System.out.println("\n Memory location for alphaCoach: "+alphaCoach);
		

		
		context.close();

	}

}
