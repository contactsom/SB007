package com.simplilearn.log.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.log.Customer;
import com.simplilearn.utill.HibernateUtillXml;

public class CustomerClient {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {
			factory= HibernateUtillXml.getSessionFactory();
			session= factory.openSession();
			tx = session.beginTransaction();
			Customer customer= new Customer("Drazen Drinic ", "Drazendrinic@simplilearn.com ", new Date(), new Long(12345));
			session.save(customer);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("#### Error Occured while Inserting the data");
		}
		//9. Close the Resource
		session.close();
		factory.close();
	}
}
