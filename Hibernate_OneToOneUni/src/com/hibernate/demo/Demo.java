package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class Demo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
//			  Instructor instructor = new Instructor("Alek", "Wass",
//			  "alek.wass@gmail.com"); InstructorDetail instrDetail = new
//			  InstructorDetail("IT", "coding");
			 
			Instructor instructor = new Instructor("Mona", "Black", "mona@gmail.com");
			InstructorDetail instrDetail = new InstructorDetail("Music", "guitar");

			instructor.setInstructorDetail(instrDetail);

			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
