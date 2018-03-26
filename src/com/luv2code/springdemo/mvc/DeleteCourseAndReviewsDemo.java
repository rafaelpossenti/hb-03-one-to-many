package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.springdemo.entity.Course;
import com.luv2code.springdemo.entity.Instructor;
import com.luv2code.springdemo.entity.InstructorDetail;
import com.luv2code.springdemo.entity.Review;

public class DeleteCourseAndReviewsDemo {
	public static void main(String Args[]) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create new session 
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction 
			session.beginTransaction();
			
			//get the course
			int id = 1 ; 
			Course course = session.get(Course.class,id);
			
			session.delete(course);
			
	
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			//add clean up code
			session.close();
			factory.close();
		}
	}	
}