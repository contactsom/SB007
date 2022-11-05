<%@page import="com.simplilearn.beans.Customer" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert.JSP</title>
</head>
<body>

	<%
		Customer customer1 = new Customer();
		customer1.setCid(202);
		customer1.setCname("Pankaj");
		customer1.setEmail("pankaj@simplilearn.com");
		customer1.setPhone(9876124);
		session.setAttribute("CUST1", customer1);
		
		
		Customer customer2 = new Customer();
		customer2.setCid(203);
		customer2.setCname("Gyan");
		customer2.setEmail("gyan@simplilearn.com");
		customer2.setPhone(9865124);
		session.setAttribute("CUST2", customer2);
		
	%>
	
	<jsp:forward page="display.jsp"/>
	
</body>
</html>