package com.simplilearn.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementExample {

	public static void main(String[] args) {
		try {
			//1. Load the Driver
			//Class.forName("com.mysql.jdbc.Driver"); /*This is deprecated. */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Get the Connection 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sb007","root","root12345");
			
			//3. Create the Statement.
			Statement stmt = con.createStatement();
			
			//4. Prepare the Query & Execute.
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");/*Fetch The Record*/
			
			while(rs.next()) {
				System.out.println("ID - "+rs.getInt(1)+" "+
				"Age - "+rs.getInt(2)+" "+
				"First Name - "+rs.getString(3)+" "+
				"Last Name - "+rs.getString(4)
				);
			}
			
			//5. CLose the Resource .
			con.isClosed();
			stmt.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error Occured While fetching the data from the Table Employeese ");
		}
		
	}
}
