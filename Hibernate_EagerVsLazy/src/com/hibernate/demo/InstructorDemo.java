package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class InstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor instructor = new Instructor("Alek", "Wass", "alek.wass@gmail.com");
			InstructorDetail instrDetail = new InstructorDetail("IT", "coding");

			instructor.setInstructorDetail(instrDetail);

			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
