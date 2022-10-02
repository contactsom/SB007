package com.simplilearn.jdbc.utillstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.simplilearn.jdbc.utill.JDBCUtill;

public class StatementExample {

	public static void main(String[] args) {
		try {
			
			Connection con=JDBCUtill.getMySqlConnection();
			
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
			
			JDBCUtill.cleanUp(con, stmt, rs);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error Occured While fetching the data from the Table Employeese ");
		}
		
	}
}
