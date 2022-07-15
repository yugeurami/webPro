<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MemberResult</title>
	<link href="${conPath }/css/style.css" rel="stylesheet"> 
</head>
<body>
	<h2>어떤 요청이 들어와도 cnt, list 출력</h2>
	<h3>cnt : ${cnt }</h3>
	<h3>list : ${list }</h3>
	<hr>
	<table>
		<caption>join4.jsp 페이지에서 넘어온 개인 정보</caption>
		<tr>
			<th>이름</th>
			<td>${member.name }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${member.pw }</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${member.age }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member.email }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${member.address }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="history.back()">뒤로가기</button>
				<button onclick="location.href='${conPath }/'">메인 페이지로 가기</button>
			</td>
		</tr>
	</table>
</body>
</html>