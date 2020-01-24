package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Course;
import com.mosquito.springstudy.entity.Instructor;
import com.mosquito.springstudy.entity.InstructorDetail;
import com.mosquito.springstudy.entity.Review;
import com.mosquito.springstudy.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Course c = new Course("xesque 2");
		session.save(c);
		
		Student s1 = new Student("a", "b", "ab@co.co");
		Student s2 = new Student("c", "d", "cd@co.co");
		
		c.addStudent(s1);
		c.addStudent(s2);
		
		session.save(s1);
		session.save(s2);
		
		
		session.getTransaction().commit();

		factory.close();
	}

}
