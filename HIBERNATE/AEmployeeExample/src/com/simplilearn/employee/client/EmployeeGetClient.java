package com.simplilearn.employee.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.simplilearn.employee.Employee;

public class EmployeeGetClient {

	public static void main(String[] args) {

		System.out.println("********** START-CustomerClient**************");
		
		SessionFactory factory = null;
		Transaction tx = null;
		Session session = null;
		try {
			
			//1. Create the Configuration Object
			AnnotationConfiguration acfg= new AnnotationConfiguration();
			System.out.println("----------1. Create the Configuration Object----------");
			
			//2. Call the Configure Method
			acfg=(AnnotationConfiguration) acfg.configure();
			System.out.println("----------2. Call the Configure Method----------");
			
			//3. Through the Configuration Object Call the Build Session Factory
			factory = acfg.buildSessionFactory();
			System.out.println("----------3. Through the Configuration Object Call the Build Session Factory----------");
			
			//4. With the help of factory object open the session
			session= factory.openSession();
			System.out.println("----------4. With the help of factory object open the session----------");
			
			//5. With the Help of Session object call the begin transaction
			tx = session.beginTransaction();
			System.out.println("----------5. With the Help of Session object call the begin transaction----------");
			
			//6. Prepare the Business Object
			System.out.println("----------6. Prepare the Business Object----------");
			Employee employeeData=(Employee)session.get(Employee.class, 2);// First Argument is your Entity Class and Second is your PK or Where Condition.
			
			System.out.println("EMPLOYEE ID : "+employeeData.getEmpid()+" "+
								"EMPLOYEE NAME :"+employeeData.getEmpname()+" "+
								"EMPLOYEE EMAIL :"+employeeData.getEmpemail()+" "+
								"EMPLOYEE SALARY : "+employeeData.getEmpsalary()+" "+
								"EMPLOYEE DESIGNATION : "+employeeData.getEmpdesignation()+" "+
								"EMPLOYEE ADDRDESS : "+employeeData.getEmpaddress());
		} catch (Exception e) {

			e.printStackTrace();
			System.err.println("#### Error Occured while fetching the data");
		}
		
		//9. Close the Resource
		session.close();
		factory.close();
		System.out.println("----------9. Close the Resource----------");
		
		System.out.println("********** END-CustomerClient**************");
	

	
	}
}
