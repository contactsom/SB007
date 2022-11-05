<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home JSP</title>
</head>
<body>

	<h1> This is First JSP Example</h1>
	<h2> JSP Decleration Using Declerative tag</h2>
	
	<%!
		int a=10;
	 	int b=20;
	 	String course="JSP Tutorials";
	 	
	 	public int getSum(){
	 		return a+b;
	 	}
	
	 	public String getCourse(){
	 		return course;
	 	}
	%>
	
	<h2> ************ JSP Calling JAVA Code Using Scriptlet Tag ************ </h2>
	
	<%
		out.print(a);
		out.print("<br>");
		out.print(b);
		out.print("<br>");
		out.print(getSum());
		out.print("<br>");
		out.print(getCourse());
	%>
	
	<h2> ************ JSP Calling JAVA Code Using JSP Expression Tag ************ </h2>
	
	<%=a %>
	<br>
	<%=b %>
	<br>
	<%=getSum() %>
	<br>
	<%=getCourse() %>
	
</body>
</html>