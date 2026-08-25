<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<h1>user name is :: ${initParam.username}</h1>
	<h1>password is :: ${initParam.password}</h1>
	<h1>email is :: ${initParam.emailid}</h1>
	<hr>
	<br>
	<b>Working with page context object</b>
	<h1>Pagecontext details is :: ${pageContext}</h1>
	<h1>header details is :: ${header}</h1>
	<h1>session details is :: ${pageContext.session.id}</h1>
	<h1>request method  is :: ${pageContext.request.method}</h1>
</body>
</html>