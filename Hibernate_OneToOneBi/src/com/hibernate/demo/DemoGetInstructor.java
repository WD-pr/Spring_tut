package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DemoGetInstructor {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int id = 1;

			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

			System.out.println("InstructorDetail: " + instructorDetail);

			System.out.println("Instructor : " + instructorDetail.getInstructor());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			/* Resolving leak issue when exception encountered*/
			session.close();
			
			factory.close();
		}

	}

}
