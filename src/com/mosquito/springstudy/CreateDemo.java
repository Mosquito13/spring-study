package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Instructor instructor = new Instructor("xesque", "bresque", "x.b@go.co");
		InstructorDetail instructorDetail = new InstructorDetail("yt/xesque", "cresque");
		
		instructor.setInstructorDetail(instructorDetail);
		
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.save(instructor);
		session.getTransaction().commit();
		
		factory.close();
	}

}
