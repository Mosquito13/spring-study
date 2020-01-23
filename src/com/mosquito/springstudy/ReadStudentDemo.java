package com.mosquito.springstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mosquito.springstudy.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Student student = new Student("xesque", "bresque", "a@sys.co");
		session.save(student);
		session.getTransaction().commit();
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		Student student2 = session.get(Student.class, student.getId());
		System.out.println("\n\n" + student2 + "\n\n");
		session.getTransaction().commit();

		factory.close();
	}
}
