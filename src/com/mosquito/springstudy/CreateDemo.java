package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Course;
import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Instructor i = new Instructor("first", "last", "mail@oi.co");
		InstructorDetail id = new InstructorDetail("yt", "idk");
		Course c1 = new Course("xesque");
		Course c2 = new Course("bresque");
		
		i.setInstructorDetail(id);
		
		i.addCourse(c1);
		i.addCourse(c2);
		
		session.save(i);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}

}
