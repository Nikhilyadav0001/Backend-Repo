<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form page</title>
</head>
<body>
	
	<h1 style='color:red; text-align:center;'>ENTER STUDENT DETAILS</h1>
	
	<form action="./student.jsp" method ="post">
	<table>
		<thead>
			<tr>
				<th>NAME</th>
				<td>
					<input type ='text' name='name'/>
				</td>
			</tr>
			
			<tr>
				<th>AGE</th>
				<td>
					<input type ='number' name='age'/>
				</td>
			</tr>
			
			<tr>
				<th>ADDRESS</th>
				<td>
					<input type ='text' name='address'/>
				</td>
			</tr>
			
			<tr>
				<th></th>
				<td>
					<input type ='submit' name='register'/>
				</td>
			</tr>
		</thead>
	</table>
	</form>
</body>
</html>