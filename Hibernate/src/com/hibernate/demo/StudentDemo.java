package com.hibernate.demo;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println(Locale.getDefault());
			
			String d = "12/12/1990";
			Date date = DateUtils.parseDate(d);
			System.out.println(date);
			Student student = new Student("Alek", "Wass", date, "alek.wass@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		
	}

}
