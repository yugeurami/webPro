<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MemberLogin</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>member의 ${result }.jsp 페이지입니다</h2>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>