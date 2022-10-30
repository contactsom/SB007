package com.simplilearn.session.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionDemoServlet  extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("***************START-service()***************");
		
		String firstname =(String)request.getParameter("firstname");
		String emailid =(String)request.getParameter("emailid");
		
		System.out.println("First Name:-"+firstname);
		System.out.println("Email ID :-"+emailid);
		
		HttpSession session = request.getSession();
		
		System.out.println("Is New :: - "+session.isNew());
		System.out.println("SESSION ID :: - "+session.getId());
		System.out.println("SESSION CREATED TIME  :: - "+session.getCreationTime());
		System.out.println("SESSION LAST ACCESS TIME  :: - "+session.getLastAccessedTime());
		
		
		ServletConfig sconfig  = getServletConfig();
		ServletContext context = sconfig.getServletContext();
		
		request.setAttribute("EM1", emailid);
		session.setAttribute("EM2", emailid);
		context.setAttribute("EM3", emailid);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		
		rd.forward(request, response);
		
		
		System.out.println("***************END-service()***************");
	}

}
