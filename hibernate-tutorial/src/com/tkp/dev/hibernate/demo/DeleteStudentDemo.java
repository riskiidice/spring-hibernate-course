package com.tkp.dev.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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
		
			System.out.println("Delete student....");
			
			session.delete(myStudent);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
	}


}