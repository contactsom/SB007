package com.simplilearn.lms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.simplilearn.jdbc.utill.JDBCUtill;
import com.simplilearn.lms.book.Book;

public class BookService {

	Connection con=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public String verifyUser(String user, String password) {

		System.out.println("*******START- verifyUser *********");
		String verifyUser="";
		try {
			
			con = JDBCUtill.getMySqlConnection();
			ps = con.prepareStatement("SELECT * FROM USERS WHERE USER_NAME = ? AND USER_PASSWORD = ?");
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();// Value Found 
			
			// if rs is suppling any value than use name and passowrd in correct 
			// else not correct
			
			if(rs.next()) {
				System.out.println("User Logged Successfully");
				verifyUser="Logged Successfully";
			}else {
				System.out.println("Login failed");
				verifyUser="Sorry !!! Login failed ";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("*******END- verifyUser *********");
		return verifyUser;
		
	}

		public int addBooks(Book book) {
				System.out.println("***********START-addBooks*************");
				int records=0;
				try {
					con = JDBCUtill.getMySqlConnection();
					ps = con.prepareStatement("INSERT INTO BOOKS VALUES (?,?,?,?,?,?)");
					ps.setInt(1, book.getBookid());
					ps.setString(2, book.getBookname());
					ps.setString(3, book.getBookauthor());
					ps.setString(4, book.getBookpublication());
					ps.setInt(5, book.getBookprice());
					ps.setInt(6, book.getIsbn());
					records=ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("***********END-addBooks*************");
				return records;
		}
	
	
	
	
	
	
	
	
	
	
	

}
