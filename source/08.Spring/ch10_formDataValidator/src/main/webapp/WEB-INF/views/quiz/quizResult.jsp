<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>RESULT</title>
</head>
<body>
	<table>
		<caption>결과는 다음과 같습니다</caption>
		<tr>
			<th>이름 : </th>
			<td>${quiz.name }</td>
		</tr>
		<tr>
			<th>국어 : </th>
			<td>${quiz.kor }</td>
		</tr>
		<tr>
			<th>영어 : </th>
			<td>${quiz.eng }</td>
		</tr>
		<tr>
			<th>수학 : </th>
			<td>${quiz.mat }</td>
		</tr>
		<tr>
			<th>총점 : </th>
			<td>${quiz.tot }</td>
		</tr>
		<tr>
			<th>평균 : </th>
			<td><fmt:formatNumber value="${quiz.avg }" pattern=".00" /></td>
		</tr>
	</table>
</body>
</html>