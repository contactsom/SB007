<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOW</title>
</head>
<body>

	<h1> Congratulations !!! You are registred successfully</h1>
	
	FIRST Name : <%= request.getAttribute("FNAME")%>
	<br>
	LAST Name : <%= request.getAttribute("LNAME")%>
	<br>
	EMAIL : <%= request.getAttribute("EMAIL")%>
	<br>
	PASSWORD : <%= request.getAttribute("PASSWORD")%>
	
	
</body>
</html>