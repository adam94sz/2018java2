<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello JSP!</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<h3>Currrent time:<%= LocalDateTime.now() %></h3>
	<a href="hello-servlet">Hello Servlet</a>
	
	
	<form id="formId" action="hello-servlet" method="post">
		<input type="text" name="helloInput" value="ird ide a neved">
		<input type="submit">
		
		<a onclick="document.getElementById('formId').submit()">Elküld</a>
	</form>
</body>
</html>