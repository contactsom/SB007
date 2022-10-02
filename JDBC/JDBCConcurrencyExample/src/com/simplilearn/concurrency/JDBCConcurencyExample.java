package com.simplilearn.concurrency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.simplilearn.jdbc.utill.JDBCUtill;

public class JDBCConcurencyExample {

	public static void main(String[] args) {
		
		System.out.println("******* START- JDBCConcurencyExample **********");
		try {
			Connection con = JDBCUtill.getMySqlConnection();
			//Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY ); // TODO
			
			Statement stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE ); 
			
			ResultSet rs = stmt.executeQuery("select * from STUDENT");
			
			System.out.println("*** Before Update *********");
			
			while(rs.next()) {
				System.out.println("STUDENT_ID - "+rs.getInt(1)+" "+
				"STUDENT_AGE - "+rs.getInt(2)+" "+
				"STUDENT_FNAME - "+rs.getString(3)+" "+
				"STUDENT_LNAME -  "+rs.getString(4)
				);
			}
			// ENd of the Row 
			rs.beforeFirst();
			
			/* I want to increase the all Student age by 10 Years*/
			while(rs.next()) {
				int updatedAge= rs.getInt(2)+10;
				rs.updateInt("STUDENT_AGE", updatedAge);
				rs.updateRow();
			}
			
			// ENd of the Row 
			rs.beforeFirst();
			
			System.out.println("*** After Update *********");
			
			while(rs.next()) {
				System.out.println("STUDENT_ID - "+rs.getInt(1)+" "+
				"STUDENT_AGE - "+rs.getInt(2)+" "+
				"STUDENT_FNAME - "+rs.getString(3)+" "+
				"STUDENT_LNAME -  "+rs.getString(4)
				);
			}
			
			JDBCUtill.cleanUp(con, stmt, rs);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while updating the data");
		}
		
		System.out.println("******* END- JDBCConcurencyExample **********");
		
	}
}
