package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class DeleteCourseReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int id = 10;
			
			Course course = session.get(Course.class, id);
			
			System.out.println("Deleting course with cascading: \n" + course + System.lineSeparator());
			
			session.delete(course);
						
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
