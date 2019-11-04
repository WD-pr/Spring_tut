package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println(instructor);
			
			/* Loaded to avoid an exception org.hibernate.LazyInitializationException*/
			System.out.println(instructor.getCourses());
			
			session.getTransaction().commit();
			
			/*
			 * Courses loaded before commit of transaction - there is no lazy initialization
			 * exception
			 */
			System.out.println(instructor.getCourses());
			
			System.out.println("Done !");

		} finally {
			
			session.close();
			
			factory.close();
		}

	}

}
