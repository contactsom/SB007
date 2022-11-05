package com.simplilearn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.simplilearn.jdbc.utill.JDBCUtill;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class StudentServlet extends HttpServlet {

		public static final String INSERT="INSERT INTO STUDENT_PROJECT VALUES(?,?,?,?)";
		public static final String SEARCH_BY_EMAIL_ID="SELECT * FROM STUDENT_PROJECT WHERE EMAIL = ?";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***************START-doPost()***************");

		String path = request.getServletPath();
		System.out.println("Path- " + path);

		switch (path) {
		case "/insert":
				insertData(request, response);
			break;

		case "/search":
				getByEmailId(request, response);
		break;
		
		case "/update":
			/*Home Work*/
		break;
	
		case "/delete":
			/*Home Work*/
		break;
		
		default:
			break;
		}
		System.out.println("***************END-doPost()***************");

	}

	private void getByEmailId(HttpServletRequest request, HttpServletResponse response) {

		String emailid = (String) request.getParameter("emailid");
		System.out.println("Email :" + emailid);
		
		try {
			Connection con = JDBCUtill.getMySqlConnection();
			PreparedStatement pstmt = con.prepareStatement(SEARCH_BY_EMAIL_ID);
			pstmt.setString(1, emailid);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String fname=rs.getString("FIRST_NAME");
				String lname=rs.getString("LAST_NAME");
				String email=rs.getString("EMAIL");
				String password=rs.getString("PASSWORD");
				
				System.out.println("First Name : "+fname);
				System.out.println("Last Name : "+lname);
				System.out.println("Email ID : "+email);
				System.out.println("PASSWORD : "+password);
				
				displaySearchResult(fname,lname,email,password,request,response);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error Occured While Searching the data from STUDENT_PROJECT Table ");

		}
	}

	private void displaySearchResult(String fname, String lname, String email, String password,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*********START-displaySearchResult()*********");

		request.setAttribute("FNAME", fname);
		request.setAttribute("LNAME", lname);
		request.setAttribute("EMAIL", email);
		request.setAttribute("PASSWORD", password);
		
		RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
		rd.forward(request, response);
		
		System.out.println("*********END-displaySearchResult()*********");
	}

	private void insertData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("***************START-insertData()***************");
		
		String firstname = (String) request.getParameter("firstname");
		String lastname = (String) request.getParameter("lastname");
		String emailid = (String) request.getParameter("emailid");
		String password = (String) request.getParameter("password");

		System.out.println("First Name :" + firstname);
		System.out.println("Last Name :" + lastname);
		System.out.println("Email :" + emailid);
		System.out.println("Password :" + password);

		// Logic to Save the DATA in to DB

		try {
			Connection con = JDBCUtill.getMySqlConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, emailid);
			pstmt.setString(4, password);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error Occured While Inserting the data in to STUDENT_PROJECT ");

		}
		
		display(request, response);
		System.out.println("***************END-insertData()***************");

	}

	private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("***************START-display()***************");
		
		String firstname = (String) request.getParameter("firstname");
		String lastname = (String) request.getParameter("lastname");
		String emailid = (String) request.getParameter("emailid");
		String password = (String) request.getParameter("password");

		System.out.println("First Name :" + firstname);
		System.out.println("Last Name :" + lastname);
		System.out.println("Email :" + emailid);
		System.out.println("Password :" + password);

		request.setAttribute("FNAME", firstname);
		request.setAttribute("LNAME", lastname);
		request.setAttribute("EMAIL", emailid);
		request.setAttribute("PASSWORD", password);
		
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		rd.forward(request, response);
		
		System.out.println("***************END-display()***************");
	}
	
	
}
