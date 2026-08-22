<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*,in.pwskills.nitin.beans.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UI PAGE</title>
</head>
<body>	
	<h1>STUDENT RELATIONSHIP MANAGEMENT</h1>
	<c:import url="urlrelated.jsp">
		<c:param name="UI" value="THYMLEAF"/>
		<c:param name="FRAMEWORK" value="Spring and SpringBoot"/>
	</c:import>

	<br>
	<h1>STUDENT RELATIONSHIP MANAGEMENT</h1>
	<c:redirect url="urlrelated.jsp">
		<c:param name="UI" value="THYMLEAF"/>
		<c:param name="FRAMEWORK" value="Spring and SpringBoot"/>
	</c:redirect>	
</body>
</html>




