<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="../Ex3">
		<h3>누적할 수</h3><input type="number" name="su" min="1" required="required">
		<input type="submit">
	</form>
</body>
</html>