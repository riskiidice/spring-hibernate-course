package com.tkp.dev.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.firstName='Tikumporn' ").getResultList();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.firstName='Tikumporn' "+ 
						  "OR s.lastName='Duck'").getResultList();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.firstName LIKE '%porn'").getResultList();
		
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			
			 
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}