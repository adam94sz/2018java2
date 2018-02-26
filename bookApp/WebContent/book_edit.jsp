<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="book_edit" method="post">
	<table border="1">
		<tr>
		<td>Könyv az</td>
		<td><input name="id" readonly="readonly" value="${book.id}"></td>
		</tr>
		<tr>
		<td>Könyv címe</td>
		<td><input name="title" value="${book.title }"></td>
		</tr>
			<tr>
		<td>Könyv szerzője</td>
		<td><input name="author" value="${book.author }"></td>
		</tr>
			<tr>
		<td>Könyv leírás</td>
		<td><input name="description" value="${book.description }"></td>
		</tr>
		
			<tr>
		<td>Kiadás éve</td>
		<td><input name="pubYear" value="${book.pubYear }"></td>
		</tr>
	
	</table>
	
	<input type="submit" value="Mentés">
	
	</form>

</body>
</html>