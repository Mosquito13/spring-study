package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Student student = session.get(Student.class, 1);
		session.delete(student);
		
		session.getTransaction().commit();
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("delete from Student where id > 123").executeUpdate();

		session.getTransaction().commit();
		
		factory.close();
	}
}
