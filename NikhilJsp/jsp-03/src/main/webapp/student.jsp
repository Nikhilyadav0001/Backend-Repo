<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Landing page</title>
</head>
<body>
	<h1 style='color:red; text-align:center'>Working with jsp beans tags</h1>
	<jsp:useBean id="student" class="nikhil.beans.Student" scope="page"/>
	<jsp:setProperty property="name" name="student" />
	<jsp:setProperty property="age" name="student"/>
	<jsp:setProperty property="address" name="student" />
	
	<table>
		<thead>
			<tr>
				<td>NAME</td>
				<td>AGE</td>
				<td>ADDRESS</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
				<jsp:getProperty property="name" name="student"/>
				</td>
				<td>
				<jsp:getProperty property="age" name="student"/>
				</td>
				<td>
				<jsp:getProperty property="address" name="student"/>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>