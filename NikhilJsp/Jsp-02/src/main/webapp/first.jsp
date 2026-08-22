<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Landing page</title>
</head>
<body>
	<h1 style='color:red; text-align:center;'> 
	First jsp page
	 </h1>
	 <%--Script element --%>
	 <% 
	 pageContext.include("second.jsp");
	 %>
	<h1 style='color:red; text-align:center;'> 
	Footer of the  jsp page
	 </h1>

</body>
</html>