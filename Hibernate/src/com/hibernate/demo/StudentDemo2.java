package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentDemo2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Wer", "Wak", null, "wer@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			////////////
			
			System.out.println("Generated student id: " + student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student getStudent = session.get(Student.class, student.getId());
			
			System.out.println("\nGot student:\t" + getStudent);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		
	}

}
