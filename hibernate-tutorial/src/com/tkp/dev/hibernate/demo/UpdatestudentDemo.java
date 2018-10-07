package com.tkp.dev.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatestudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			
			int studentId = 1;
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
		
			System.out.println("Update student....");
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			System.out.println("Update email for all students");
			session.createQuery("update Student set email ='foo@bar.com' ")
					.executeUpdate();
			
			session.getTransaction().commit();
			 
			
		}finally {
			factory.close();
		}
	}


}