<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARGET PAGE</title>
</head>
<body>
	<br>
	<br>
	<br>
	<!-- list :: policyList take and print the results -->
	<c:choose>
		<c:when test="${policyList ne null && !empty policyList}">
			<!-- print recordds-->
			<table border="1" align="center">
				<tr>
					<th>SERIALNO</th>
					<th>POLICYID</th>
					<th>POLICYNAME</th>
					<th>POLICYTYPE</th>
					<th>COMPANY</th>
					<th>TENURE</th>
				</tr>
				<c:forEach var = "dto" items="${policyList}">
					<tr>
						<td>${dto.serialno}</td>
						<td>${dto.policyId}</td>
						<td>${dto.policyName}</td>
						<td>${dto.policyType}</td>
						<td>${dto.company}</td>
						<td>${dto.tenure}</td>
					</tr>
				</c:forEach>
			</table>
			
			<!-- BUILD UI TO REPRESENT PAGINATION -->
			<center>
				<!-- PREVIOUS button -->
			    <c:if test="${pageNo > 1}">
			        <b><a href='controller?pageNo=${pageNo-1}&s1=link'>PREVIOUS</a></b>&nbsp;&nbsp;
			    </c:if>
				
				<!-- USE PAGE COUNT TO PREPAREA LINK FOR PAGINATION-->
				<c:forEach var='i' begin='1' end="${pageCount}" step="1">
					<b><a href ='controller?pageNo=${i}&s1=link'>[${i}]</a></b>&nbsp;&nbsp;
				</c:forEach>
			
				<!-- NEXT button -->
			    <c:if test="${pageNo < pageCount}">
			        <b><a href='controller?pageNo=${pageNo+1}&s1=link'>NEXT</a></b>&nbsp;&nbsp;
			    </c:if>
				
			</center>
		
		</c:when>
		<c:otherwise>
			<!-- print record not avalable -->
			<h1 style="color: red ;text-align: center;">no record found</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>