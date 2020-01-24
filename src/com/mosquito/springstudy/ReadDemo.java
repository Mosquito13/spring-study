package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Course;
import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;

public class ReadDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Instructor i = session.get(Instructor.class, 1);
		
		System.out.println("\nInstructor:\n" + i);
		System.out.println("\nCourses: ");
		
		for (Course c : i.getCourses()) {
			System.out.println(c);
		}
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}

}
