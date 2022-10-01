package com.simplilearn.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertMultiRecordsStatementExample {

	public static void main(String[] args) {
		try {
			//1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Get the Connection 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sb007","root","root12345");
			
			//3. Create the Statement.
			Statement stmt = con.createStatement();
			
			//4. Prepare the Query & Execute.
			int records1 = stmt.executeUpdate("INSERT INTO Employees VALUES (108, 22, 'Eshal', 'Rifa')");
			int records2 = stmt.executeUpdate("INSERT INTO Employees VALUES (109, 23, 'Arsha', 'Anagha')");
			int records3 = stmt.executeUpdate("INSERT INTO Employees VALUES (110, 24, 'Divya', 'Rajiv')");
			int records4 = stmt.executeUpdate("INSERT INTO Employees VALUES (111, 25, 'Preetha', 'Danush')");
			
			if(records1>0 && records2>0 && records3>0 && records4>0 ) {
				System.out.println("Record Inserted Successfully in to table Employees");
			}else {
				System.out.println("Error occured while inserting the data  in to table Employees");
			}
			
			//5. CLose the Resource .
			con.isClosed();
			stmt.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error occured while inserting the data  in to table Employees ");
		}
		
	}
}
