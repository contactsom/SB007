package com.simplilearn.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.simplilearn.jdbc.utill.JDBCUtill;

public class PreparedStatementExample {

	public static void main(String[] args) {
		
		System.out.println("****** START- DATA Insert Using Prepared Statement ");
		Connection con=null;
		try {
			
			con=JDBCUtill.getMySqlConnection();
			PreparedStatement ps= con.prepareStatement("INSERT INTO STUDENT VALUES (?, ?, ?, ?)"); /*Place Holder */
			//INSERT INTO STUDENT VALUES (501, 22, 'Drazen', 'Drinic')
			
			/*First Record*/
			ps.setInt(1, 501);
			ps.setInt(2, 22);
			ps.setString(3, "Drazen");
			ps.setString(4, "Drinic");
			ps.execute();
			
			/*Second Record*/
			ps.setInt(1, 502);
			ps.setInt(2, 32);
			ps.setString(3, "Francesco");
			ps.setString(4, "Sebastian");
			ps.execute();
			
			/*Third Record*/
			ps.setInt(1, 503);
			ps.setInt(2, 25);
			ps.setString(3, "Daniel");
			ps.setString(4, "Thies");
			ps.execute();
			
			JDBCUtill.cleanUp(con, ps);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("****** END- DATA Insert Using Prepared Statement ");
		
	}
}
