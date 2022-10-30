<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show JSP</title>
</head>
<body>
	Email from REQUEST : <%= request.getAttribute("EM1")%>
	<br>
	Email from SESSION : <%= session.getAttribute("EM2")%>
	<br>
	Email from APPLICATION : <%= application.getAttribute("EM3")%>
	<br>
</body>
</html>