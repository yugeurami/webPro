<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>studentNg</title>
</head>
<body>
	<h1>studentNg.jsp 페이지입니다</h1>
	<h3>모델의 ID는 존재하지 않음</h3>
	<h3>파라미터로 받은 ID : ${param.id }</h3>
</body>
</html>