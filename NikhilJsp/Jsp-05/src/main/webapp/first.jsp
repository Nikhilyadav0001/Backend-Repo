<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Landing page</title>
</head>
<body>
	<b>first.jsp</b>
	<%
		float bAmount = 300.0f +(3000.0f*0.03f);
	%>
	<jsp:forward page="second.jsp">
	<jsp:param value="JSP" name="bookName"/>
	<jsp:param value="<%= bAmount%>" name="amount"/>
	</jsp:forward>
	<br>
	<br>
	<b>End of first jsp</b>	
	
</body>
</html>