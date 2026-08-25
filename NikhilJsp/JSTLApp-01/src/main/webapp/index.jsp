<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP PAGE</title>
</head>
<body>
	<h1>WORKING WITH CORE TAGS</h1>
	<%--print ot console  --%>
	
	
	<%--must use tomcat 9 not 10 --%>
	
	
	<c:out value="${param.user}"/>
	<br>
	<c:set var="x" value="10" scope="request"/>
	<c:set var="y" value="20" scope="request"/>
	<c:set var="sum" value="${x+y}" scope="request"/>
	<h1>the result is::<c:out value="${sum}"/></h1>
	
	<h1>removing the variable from a perticular scope </h1>
	<c:remove var="sum" scope ="request"/>
	<h1>the result is::<c:out value="${sum}" default="20000"/></h1>
	
	<h1>working with conditional tags</h1>
	<c:set var="msg" value="welcome to jstl" scope="request"/>
	<c:if test="${empty param.user}">
    	<c:out value="${msg}"/>
	</c:if>

	<h1>working with switch</h1>
	<c:choose>
		<c:when test="${param.no gt 0}">
			${param.no} is positive
		</c:when>
		<c:when test="${param.no lt 0}">
			${param.no} is negitive
		</c:when>
		<c:otherwise>
			${param.no} is zero
		</c:otherwise>
	</c:choose>	
	
</body>
</html>