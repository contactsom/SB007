package com.simplilearn.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.simplilearn.jdbc.utill.JDBCUtill;

public class SelectPreparedStatementExample {

	public static void main(String[] args) {
		
		System.out.println("****** START- Get the DATA from Table using  Prepared Statement ");
		Connection con=null;
		ResultSet rs= null;
		try {
			
			con=JDBCUtill.getMySqlConnection();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM STUDENT WHERE STUDENT_ID = ?"); /*Place Holder */

			ps.setInt(1, 501);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("STUDENT_ID - "+rs.getInt(1)+" "+
				"STUDENT_AGE - "+rs.getInt(2)+" "+
				"STUDENT_FNAME - "+rs.getString(3)+" "+
				"STUDENT_LNAME -  "+rs.getString(4)
				);
			}
			
			JDBCUtill.cleanUp(con, ps,rs);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("****** END- Get the DATA from Table using  Prepared Statement ");
		
	}
}
