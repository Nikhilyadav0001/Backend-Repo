<%@page import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>Scriptlet tag</b><br>
	<% 
	int a =10;
	out.println("the output is::"+a);
	 %>
	 <br>
	<% 
	out.println("brouser name is ::"+request.getHeader("user-agent"));
	 %>
	 <%! 
	 int [] a = {10,20,49,30};
	 
	 public void disp(){
		 for(int data: a){
			 System.out.println(data);
		 }
	 }
	 %>
	 <% disp(); %>
	 <%!
	 @Override
	 public void jspInit(){
		 System.out.println("initialization");
	 }
	 %>
	 
	 
</body>
</html>