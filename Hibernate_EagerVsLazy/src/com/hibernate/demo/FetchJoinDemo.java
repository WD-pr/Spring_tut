package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;

			Query<Instructor> query = session
					.createQuery("from Instructor i JOIN FETCH i.courses where i.id=:theId", Instructor.class);
			query.setParameter("theId", id);

			/* Executing query that loads instructor with associated courses */
			Instructor instructor = query.getSingleResult();
			
			System.out.println(instructor);

			session.getTransaction().commit();
			

			System.out.println(instructor.getCourses());

			System.out.println("Done !");

		} finally {

			session.close();

			factory.close();
		}

	}

}
