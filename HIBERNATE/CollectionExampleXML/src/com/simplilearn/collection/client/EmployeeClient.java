package com.simplilearn.collection.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.collection.Employee;
import com.simplilearn.utill.HibernateUtillXml;

public class EmployeeClient {

	public static void main(String[] args) {
		
		System.out.println("********** START-EmployeeClient**************");
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {

			factory= HibernateUtillXml.getSessionFactory();
			session= factory.openSession();
			tx = session.beginTransaction();

			String[] empcourse= {"JAVA","HIBERNATE","JDBC","JSP"};
			
			List<String> empemails = new ArrayList<String>();
			empemails.add("annujoon@simplilearn.com");
			empemails.add("aneesathkp@simplilearn.com");
			empemails.add("gopibalaraju@simplilearn.com");
			empemails.add("drazen@simplilearn.com");
			
			List<Integer> empmarks = new ArrayList<Integer>();
			empmarks.add(50);
			empmarks.add(60);
			empmarks.add(70);
			empmarks.add(80);
			
			Set<Long> empphone = new HashSet<Long>();
			empphone.add(new Long(987614));
			empphone.add(new Long(987615));
			empphone.add(new Long(987616));
			empphone.add(new Long(987617));
			
			Map<String,Long> empreferance = new HashMap<String, Long>();
			empreferance.put("Drazen", new Long(12345));
			empreferance.put("Gopi", new Long(12346));
			empreferance.put("Annu", new Long(12347));
			empreferance.put("Shubu", new Long(12348));
			
			Employee employee = new Employee("Shubham", "03011992", "MCA", empcourse, empemails, empmarks, empphone, empreferance);
			
			session.save(employee);
			
			tx.commit();
			
			
		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("#### Error Occured while Inserting the data");
		}
		
		//9. Close the Resource
		session.close();
		factory.close();
		System.out.println("----------9. Close the Resource----------");
		
		System.out.println("********** END-EmployeeClient**************");
	

	
	}


}
