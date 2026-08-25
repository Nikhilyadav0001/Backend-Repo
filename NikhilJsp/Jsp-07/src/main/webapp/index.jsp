<%@ page import="java.util.ArrayList , nikhil.beans.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String names[]={"nikhil","sachin","sheer","kunal"};
	pageContext.setAttribute("name",names);//pagescope
	%>
	
	<h1>
	${name[0]}<br>
	${name['1']}<br>
	${name["2"]}<br>
	${name[5]}<br>
	</h1>
	<hr>
	
	<h1>Working with arrey list</h1>
	<%
		ArrayList<String> al= new ArrayList<>();
		al.add("nikhil");
		al.add("sachin");
		al.add("kunal");
		al.add("sheer");
		pageContext.setAttribute("stdName",al);
		pageContext.setAttribute("index",3);
	%>
	<h1>
	${stdName[0]}<br>
	${stdName["1"]}<br>
	${stdName['2']}<br>
	${stdName[5]}<br>
	${stdName[index]}
	</h1>
	
	<%
	ArrayList <Student> stdList = new ArrayList<Student> ();
	
	pageContext.setAttribute("student",stdList);
	
	%>
	<h1>Student list::${empty student}</h1>
	
	<hr>
	<h1>el vs null</h1>
	<h1>${10+null}</h1>
	<h1>${empty null}</h1>
	<h1>${!null}</h1>
	
</body>
</html>