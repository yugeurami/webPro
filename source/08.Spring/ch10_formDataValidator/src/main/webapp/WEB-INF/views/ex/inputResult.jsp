<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>InputResult</title>
</head>
<body>
	<table>
		<caption>검증이 완료된 결과 페이지</caption>
		<tr>
			<th>이름</th>
			<td>${student.name }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${student.id }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="history.back()">이전</button>
				<button onclick="location.href='${conPath}/inputForm.do'">다시</button>
			</td>
		</tr>
	</table>
</body>
</html>