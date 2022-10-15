package com.simplilearn.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.mapping.Customer;
import com.simplilearn.mapping.Order;
import com.simplilearn.utill.AHibernateUtill;

public class CustomerOrderClient {


	public static void main(String[] args) {
		
		System.out.println("********** START-CustomerOrderClient**************");
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {

			factory= AHibernateUtill.getSessionFactory();
			session= factory.openSession();
			tx = session.beginTransaction();

			Order order1= new Order(1, new Double(100), new Date(), "NEW");
			session.save(order1);
			Order order2= new Order(5, new Double(500), new Date(), "Replacement");
			session.save(order2);
			Order order3= new Order(3, new Double(300), new Date(), "NEW");
			session.save(order3);
			
			
			Customer customer = new Customer("Shubhu", "shubhu@simplilearn.com", new Long(897612), new Date());
			
			/*ALl the order belongs to same customer*/	
			order1.setCustomer(customer);
			order2.setCustomer(customer);
			order3.setCustomer(customer);
			
			session.save(customer);
			
			tx.commit();
			
			
		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("#### Error Occured while Inserting the data");
		}
		
		//9. Close the Resource
		session.close();
		factory.close();
		System.out.println("----------9. Close the Resource----------");
		
		System.out.println("********** END-CustomerOrderClient**************");
	

	
	}

}
