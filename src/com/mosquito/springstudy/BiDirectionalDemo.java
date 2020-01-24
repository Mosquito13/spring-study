package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;

public class BiDirectionalDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		InstructorDetail detail = session.get(InstructorDetail.class, 2);
		
		System.out.println(detail.getInstructor());
		
		session.getTransaction().commit();
		
		factory.close();
	}

}
