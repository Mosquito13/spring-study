package com.mosquito.springstudy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Student> students = session.createQuery("from Student").getResultList();
		System.out.println("\n" + students + "\n\n");
		
		students = session.createQuery("from Student s where s.lastName = 'Bresque'").getResultList();
		System.out.println("\n" + students + "\n\n");
		
		session.getTransaction().commit();

		factory.close();
	}
}
