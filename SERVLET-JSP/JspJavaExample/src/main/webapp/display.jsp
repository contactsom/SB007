<%@page import="com.simplilearn.beans.Customer" %>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
	<h1>Data Comming from Display.JSP</h1>
	
	<%
		Object obj= session.getAttribute("CUST1");
		Customer customer=null;
	
		if(obj!=null){
			customer=(Customer) obj;
		}
		
		Object obj2= session.getAttribute("CUST2");
		Customer customer2=null;
	
		if(obj2!=null){
			customer2=(Customer) obj2;
		}
		
	%>
	
	<h2>Cid:  <%= customer.getCid() %> </h2>
	<h2>Name:  <%= customer.getCname() %> </h2>
	<h2>Email:  <%= customer.getEmail() %> </h2>
	<h2>Phone: <%= customer.getPhone() %> </h2>
	
	<h2> *************************************</h2>
	
	<h2>Cid:  <%= customer2.getCid() %> </h2>
	<h2>Name:  <%= customer2.getCname() %> </h2>
	<h2>Email:  <%= customer2.getEmail() %> </h2>
	<h2>Phone: <%= customer2.getPhone() %> </h2>
	
	
</body>	
</html>