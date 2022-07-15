<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MAIN</title>
</head>
<body>
	<h1>GET 방식</h1>
	<form action="${conPath }/student.do" method="get">
		ID <input type="text" name="id">
		<input type="submit" value="GET방식으로 보내기">
	</form>
	<h1>POST 방식</h1>
	<form action="${conPath }/student.do" method="post">
		ID <input type="text" name="id">
		<input type="submit" value="POST방식으로 보내기">
	</form>
	<hr>
	<h1>redirect, forward 키워드 예제</h1>
	<form action="${conPath }/idConfirm.do" method="get">
		ID <input type="text" name="id">
		<input type="submit" value="idConfirm">
	</form>
	<hr>
	<a href="${conPath }/fullpath.do">FullPath로 가기</a>
</body>
</html>