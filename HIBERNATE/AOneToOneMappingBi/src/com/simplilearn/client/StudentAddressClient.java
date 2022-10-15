package com.simplilearn.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.mapping.Address;
import com.simplilearn.mapping.Student;
import com.simplilearn.utill.AHibernateUtill;

public class StudentAddressClient {

	public static void main(String[] args) {
		
		System.out.println("********** START-StudentAddressClient**************");
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {

			factory= AHibernateUtill.getSessionFactory();
			session= factory.openSession();
			tx = session.beginTransaction();

			Address address = new Address("2nd Main , 8th Cross,Viale Ungheria", "Evansville", "Indiana");
			Student student = new Student("Francesco", "francesco@simplilearn.com", "98761234");

			// 1 Uni + 2 Uni = Bi 
			address.setStudent(student); // 1- Uni
			student.setAddress(address); // 2- Uni
			
			session.save(address);
			session.save(student);
			
			tx.commit();
			
			
		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("#### Error Occured while Inserting the data");
		}
		
		//9. Close the Resource
		session.close();
		factory.close();
		System.out.println("----------9. Close the Resource----------");
		
		System.out.println("********** END-StudentAddressClient**************");
	

	
	}
}
