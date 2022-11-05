<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"> 
		<jsp:param value="Eatsure : Every Meals Matters " name="header"/>
	</jsp:include>
	
	<h1> Welcome to Eatsure</h1>
	<h2> Eatsure mission is better food for more people. </h2>
	
	<h3> Click on the URL to Redirect to our Portal ${param.URL}</h3>
	<h3> For any Support or Query please reach out our Customer care Email ID  ${param.HELP}</h3>
	
	<jsp:include page="footer.jsp"> 
		<jsp:param value="By continuing past this page, you agree to our Terms of Service, Cookie Policy, Privacy Policy and Content Policies. All trademarks are properties of their respective owners. 2008-2022 © Eatsure™ Ltd. All rights reserved." name="footer"/>
	</jsp:include>
</body>
</html>