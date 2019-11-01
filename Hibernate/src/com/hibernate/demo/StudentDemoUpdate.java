package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentDemoUpdate {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
			session.beginTransaction();

			Student theStudent = session.get(Student.class, studentId);
			theStudent.setFistName("Mary");

			/* Executed only when value really changed */
			session.getTransaction().commit();

			////////////////////

			session = factory.getCurrentSession();
			session.beginTransaction();

			/* Executed always */
			session.createQuery("update Student set email = 'maryjasko@gmail.com' where firstName = 'Mary'")
					.executeUpdate();

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
