package com.simplilearn.mapping.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.mapping.Address;
import com.simplilearn.mapping.Student;
import com.simplilearn.utill.HibernateUtillXml;


public class OneToOneMappingClient {

	public static void main(String[] args) {
		
		System.out.println("********** START-OneToOneMappingClient**************");
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {
			
			factory= HibernateUtillXml.getSessionFactory();
			session= factory.openSession();
			tx = session.beginTransaction();

			Address address = new Address("2nd Main , 8th Cross,Viale Ungheria", "Evansville", "Indiana");
			Student student = new Student("Francesco", "francesco@simplilearn.com", "98761234", address);
			
			/*Address address = new Address("3nd Main , 2138 N 6th Ave", "Jacksonville", "Florida");
			Student student = new Student("Drazen", "drazen@simplilearn.com", "9191234", address);*/
			
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
		
		System.out.println("********** END-OneToOneMappingClient**************");
	

	}

}
