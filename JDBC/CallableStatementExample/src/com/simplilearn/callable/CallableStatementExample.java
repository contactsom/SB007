package com.simplilearn.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.simplilearn.jdbc.utill.JDBCUtill;

public class CallableStatementExample {

	public static void main(String[] args) {
		System.out.println("START- Callable Statement ");
		
		try {
			Connection con= JDBCUtill.getMySqlConnection();
			PreparedStatement pstmt= con.prepareCall("{call GetAllStudent}");
			pstmt.execute();
			ResultSet rs= pstmt.getResultSet();
			while(rs.next()) {
				System.out.println("STUDENT_ID - "+rs.getInt(1)+" "+
				"STUDENT_AGE - "+rs.getInt(2)+" "+
				"STUDENT_FNAME - "+rs.getString(3)+" "+
				"STUDENT_LNAME -  "+rs.getString(4)
				);
			}
			JDBCUtill.cleanUp(con, pstmt, rs);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("End- Callable Statement ");
	}
	
}
