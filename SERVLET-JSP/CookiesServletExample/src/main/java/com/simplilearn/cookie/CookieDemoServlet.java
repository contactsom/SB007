package com.simplilearn.cookie;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieDemoServlet  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String email=(String)request.getParameter("email");
		
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null) {
			
			if(cookies.length!=0) {
				
				
				for (Cookie cookie : cookies) {
					
					String cookiename=cookie.getName();
					System.out.println("Cookie Name"+cookiename);
					
					if(cookiename.equals("JSESSIONID")) {
						System.out.println("Then You are OLD User");
					}else {
						System.out.println("Then You are NEW User");
					}
					
					String cookievalue= cookie.getValue();
					System.out.println("Cookie Value"+cookievalue);
					
					String cookiedomain= cookie.getDomain();
					System.out.println("Cookie Domain"+cookiedomain);
					
				}
				
				
			}else {
				System.err.println("cookies Not Found, Length ZERO");
			}
				
				
		}else {
			System.err.println("cookies Not Found");
		}
		
		
		
		Cookie c1= new Cookie("EMAIL",email);
		response.addCookie(c1);
		
		
		Cookie c2= new Cookie("PHONE","9876142");
		response.addCookie(c2);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("cookiedemo.jsp");
		
		/*Home Work to create the show.jsp and accept the value*/
		rd.forward(request, response);
		
	}
}
