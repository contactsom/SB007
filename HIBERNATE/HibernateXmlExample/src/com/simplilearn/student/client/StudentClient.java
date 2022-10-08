package com.simplilearn.student.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.student.Student;

public class StudentClient {

	public static void main(String[] args) {
		
		System.out.println("********** START-StudentClient**************");
		
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {
			
			//1. Create the Configuration Object
			Configuration cfg= new Configuration();
			System.out.println("----------1. Create the Configuration Object----------");
			
			//2. Call the Configure Method
			cfg=cfg.configure();
			System.out.println("----------2. Call the Configure Method----------");
			
			//3. Through the Configuration Object Call the Build Session Factory
			factory = cfg.buildSessionFactory();
			System.out.println("----------3. Through the Configuration Object Call the Build Session Factory----------");
			
			//4. With the help of factory object open the session
			session= factory.openSession();
			System.out.println("----------4. With the help of factory object open the session----------");
			
			//5. With the Help of Session object call the begin transaction
			tx = session.beginTransaction();
			System.out.println("----------5. With the Help of Session object call the begin transaction----------");
			
			//6. Prepare the Business Object
			//Student stu= new Student("Gopi", "gopi@simplilearn.com", 98123);
			//Student stu= new Student("Drazen", "drazen@simplilearn.com", 91123);
			Student stu= new Student("Annu", "annu@simplilearn.com", 38123);
			System.out.println("----------6. Prepare the Business Object----------");
			
			//7. Save the Data
			// Provide the Business Object to the Session
			session.save(stu);
			System.out.println("----------7. Save the Data----------");
			
			//8. Commit in to DB
			tx.commit();
			System.out.println("----------8. Commit in to DB----------");
			
		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("#### Error Occured while Inserting the data");
		}
		
		//9. Close the Resource
		session.close();
		factory.close();
		System.out.println("----------9. Close the Resource----------");
		
		System.out.println("********** END-StudentClient**************");
	}

}
