package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Course;
import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Course c = session.get(Course.class, 10);
		
		session.delete(c);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}

}
