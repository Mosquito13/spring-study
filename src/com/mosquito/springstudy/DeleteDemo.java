package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Course;
import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;
import com.mosquito.springstudy.entity.Review;
import com.mosquito.springstudy.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Course c = session.get(Course.class, 12);
		
		session.delete(c);
		
		session.getTransaction().commit();

		factory.close();
	}

}
