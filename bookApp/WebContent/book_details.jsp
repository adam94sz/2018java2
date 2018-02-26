<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">

<tr>
<td>Könyv azonosító</td>
<td><c:out value="${book.id }"></c:out></td>

</tr>

<td>Könyv címe</td>
<td><c:out value="${book.title }"></c:out></td>

</tr>

<td>Könyv szerzője</td>
<td><c:out value="${book.author }"></c:out></td>

</tr>

<td>Könyv leírás</td>
<td><c:out value="${book.description }"></c:out></td>

</tr>

<td>Könyv éve</td>
<td><c:out value="${book.pubYear }"></c:out></td>

</tr>



</table>

<a href="book_list">Vissza a könyv listára</a>

</body>
</html>