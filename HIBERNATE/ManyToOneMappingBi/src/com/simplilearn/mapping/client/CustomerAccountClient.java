package com.simplilearn.mapping.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.mapping.Account;
import com.simplilearn.mapping.Customer;
import com.simplilearn.utill.HibernateUtillXml;

public class CustomerAccountClient {

	public static void main(String[] args) {
		
		System.out.println("********** START-CustomerAccountClient**************");
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {

			factory= HibernateUtillXml.getSessionFactory();
			session= factory.openSession();
			tx = session.beginTransaction();

			Customer c1 = new Customer("Raju", "raju@simplilearn.com", new Date(), new Long(98123));
			session.save(c1);
			
			Customer c2 = new Customer("Shubhu", "shubhu@simplilearn.com", new Date(), new Long(98123));
			session.save(c2);
			
			Account a1= new Account("SAVING", 800.0);
			session.save(a1);
			
			Account a2= new Account("CURRENT", 900.0);
			session.save(a2);
			
			Account a3= new Account("CREDIT", 500.0);
			session.save(a3);
			
			Account a4= new Account("SAVING", 600.0);
			session.save(a4);
			
			Account a5= new Account("CREDIT", 400.0);
			session.save(a5);
			
			/*Set of Account hold by set object called accountset1 */
			Set<Account> accountset1= new HashSet<Account>();
			accountset1.add(a1);
			accountset1.add(a2);
			accountset1.add(a3);
			c1.setAccount(accountset1);/* Assigining three account [a1,a2,a3] to c1 */
			
			
			Set<Account> accountset2= new HashSet<Account>();
			accountset2.add(a4);
			accountset2.add(a5);
			c2.setAccount(accountset2);
			
			tx.commit();
			
			
		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("#### Error Occured while Inserting the data");
		}
		
		//9. Close the Resource
		session.close();
		factory.close();
		System.out.println("----------9. Close the Resource----------");
		
		System.out.println("********** END-CustomerAccountClient**************");
	

	
	}


}
