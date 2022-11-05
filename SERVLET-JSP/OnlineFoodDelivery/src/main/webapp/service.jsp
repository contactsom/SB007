<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SimpliEat:Service</title>
</head>
<body>
	<h1>This is SimpliEat Service</h1>
	<%
		String foodpartner=request.getParameter("foodpartners");
	
		if(foodpartner.equalsIgnoreCase("zomato")){
	%>
	
		<jsp:forward page="zomato.jsp">
			<jsp:param value="https://www.zomato.com/" name="URL"/>
			<jsp:param value="care@zomato.com" name="HELP"/>
		</jsp:forward>
		
		
	<%
		}else if(foodpartner.equalsIgnoreCase("swiggy")){
	%>
	
		<jsp:forward page="swiggy.jsp">
			<jsp:param value="https://www.swiggy.com/" name="URL"/>
			<jsp:param value="care@swiggy.com" name="HELP"/>
		</jsp:forward>
		
	<%
		}else if(foodpartner.equalsIgnoreCase("travelkhana")){
	%>	
		<jsp:forward page="travelkhana.jsp">
			<jsp:param value="https://www.travelkhana.com/" name="URL"/>
			<jsp:param value="care@travelkhana.com" name="HELP"/>
		</jsp:forward>
	
	<%
		}else if(foodpartner.equalsIgnoreCase("eatsure")){
	%>	
		
		<jsp:forward page="eatsure.jsp">
			<jsp:param value="https://www.eatsure.com/" name="URL"/>
			<jsp:param value="care@eatsure.com" name="HELP"/>
		</jsp:forward>
		
	<%
		}
	%>
</body>
</html>