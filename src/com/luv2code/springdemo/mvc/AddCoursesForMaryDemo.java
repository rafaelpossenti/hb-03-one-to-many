package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.springdemo.entity.Course;
import com.luv2code.springdemo.entity.Instructor;
import com.luv2code.springdemo.entity.InstructorDetail;
import com.luv2code.springdemo.entity.Review;
import com.luv2code.springdemo.entity.Student;

public class AddCoursesForMaryDemo {
	public static void main(String Args[]) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create new session 
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction 
			session.beginTransaction();
			
			//add the course
			Course course = new Course("Pacman");
			
			//save the course
			session.save(course);
			
			//add the students 
			Student student1 = new Student("John","Doe","john@hotmail.com");
			Student student2 = new Student("Mary","Smart","mary@hotmail.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			session.save(student1);
			session.save(student2);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			//add clean up code
			session.close();
			factory.close();
		}
	}	
}