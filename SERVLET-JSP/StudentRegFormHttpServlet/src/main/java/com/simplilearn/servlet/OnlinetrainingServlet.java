package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OnlinetrainingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("***************START-doGet()***************");
		
		String firstname =(String)request.getParameter("firstname");
		String lastname =(String)request.getParameter("lastname");
		String emailid =(String)request.getParameter("emailid");
		String password =(String)request.getParameter("password");
		
		System.out.println("First Name:-"+firstname);
		System.out.println("Last Name:-"+lastname);
		System.out.println("Email ID :-"+emailid);
		System.out.println("Password:-"+password);
		
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		
		out.print("<h1>Hired by the Best - Our Hiring Partners</h1>");
		out.print("<h2>Your Form Submitted Successfully , Our Hiring manager will connect with you soon</h2>");
		out.print("<h3> Below Data We recived</h3>");
		
		out.print("<p> First Name : :"+ firstname +"</p>");
		out.print("<p> Last Name : :"+ lastname +"</p>");
		out.print("<p> Email ID : :"+ emailid +"</p>");
		out.print("<p> Password : :"+ password +"</p>");
		
		out.print("</body>");
		out.print("</html>");
		
		
		System.out.println("***************END-doGet()***************");
	}
}
