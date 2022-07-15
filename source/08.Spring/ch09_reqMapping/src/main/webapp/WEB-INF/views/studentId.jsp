<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>studentId</title>
</head>
<body>
	<h1>studentId 페이지 입니다</h1>
	<h3>전송 방식 : ${method }</h3>
	<h3>ID : ${id }</h3>
	<h3>파라미터로 넘어온 ID : ${param.id }</h3>
</body>
</html>