package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CoursesReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Course course = new Course("Trees Drawing");
			
			course.addReview(new Review("Might be better."));
			course.addReview(new Review("Great course. Recommend everyone !!"));
			course.addReview(new Review("Pretty great course."));
			
			System.out.println(System.lineSeparator() + course);
			System.out.println(course.getReviews());
			
			session.save(course);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
