package com.simplilearn.jdbc.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtill {

	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getMySqlConnection() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sb007","root","root12345");
		return con;
	}
	
	public static Connection getOracleConnection() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1511/XE","system","****");
		return con;
	}
	
	
	public static void cleanUp(Connection con,Statement stmt) {
		try {
			if(con!=null) {
				con.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void cleanUp(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(con!=null) {
				con.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
