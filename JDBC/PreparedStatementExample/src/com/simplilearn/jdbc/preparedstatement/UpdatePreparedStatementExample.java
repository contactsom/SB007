package com.simplilearn.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.simplilearn.jdbc.utill.JDBCUtill;

public class UpdatePreparedStatementExample {

	public static void main(String[] args) {
		
		System.out.println("****** START- Update the data from Table using  Prepared Statement ");
		Connection con=null;
		ResultSet rs= null;
		try {
			
			con=JDBCUtill.getMySqlConnection();
			PreparedStatement ps= con.prepareStatement("UPDATE STUDENT SET STUDENT_AGE = ? WHERE STUDENT_ID = ?"); /*Place Holder */

			ps.setInt(1, 65);
			ps.setInt(2, 503);
			ps.executeUpdate();
			
			
			ps.setInt(1, 88);
			ps.setInt(2, 502);
			ps.executeUpdate();
			
			
			JDBCUtill.cleanUp(con, ps,rs);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("****** END- Update the data from Table using  Prepared Statement ");
		
	}
}
