package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentDemo3 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			queryStudents(session, "from Student");

			queryStudents(session, "from Student s where s.lastName = 'Wass'");

			queryStudents(session, "from Student s where s.lastName = 'Alemar' OR s.firstName = 'Wak'");
			
			queryStudents(session, "from Student s where s.email LIKE '%323%'");

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	private static void queryStudents(Session session, String hql) {

		List<Student> students = session.createQuery(hql).getResultList();

		students.forEach(System.out::println);
		System.out.println();
	}

}
