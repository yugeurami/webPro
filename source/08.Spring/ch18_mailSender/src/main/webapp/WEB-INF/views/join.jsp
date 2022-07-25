<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JOIN</title>
</head>
<body>
	<form action="textMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입(TEXT 단순 메일 전송)">
	</form>
	<hr color="green">
	<form action="htmlMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입(HTML 메일 전송)">
	</form>
</body>
</html>