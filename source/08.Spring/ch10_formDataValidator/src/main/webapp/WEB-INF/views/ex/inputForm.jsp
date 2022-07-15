<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>InputForm</title>
</head>
<body>
	<form action="${conPath }/input.do" method="get">
		<table>
			<caption>정보 입력</caption>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${student.name }"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="number" name="id" placeholder="ID는 자연수" 
							value='<c:if test="${student.id != 0 }">${student.id }</c:if>'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
	<h4>${nameError }</h4>
	<h4>${idError }</h4>
</body>
</html>