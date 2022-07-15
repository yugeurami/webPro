<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StudentOk</title>
</head>
<body>
	<h1>studentOk.jsp 페이지입니다</h1>
	<h3>모델의 ID : ${id }</h3>
	<h3>파라미터로 받은 ID : ${param.id }</h3>
</body>
</html>