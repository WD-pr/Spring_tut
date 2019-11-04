package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DemoDelete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int idToDelete = 4;

			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, idToDelete);

			System.out.println("Deleting with cascading: " + instructor);

			if (instructor != null) {
				session.delete(instructor);
			}

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
