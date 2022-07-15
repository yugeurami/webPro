<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StudentId</title>
	<link href="${conPath }/css/style.css" rel="stylesheet"> 
</head>
<body>
	<h1>studentId.jsp 페이지입니다</h1>
	<h2>URL로 넘어온 ID : ${id }</h2>
</body>
</html>