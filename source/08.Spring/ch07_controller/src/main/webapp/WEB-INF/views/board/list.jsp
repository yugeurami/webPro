<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BoardList</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>board의 list.jsp 페이지입니다</h2>
	<hr>
	<c:if test="${list.size() eq 0 }">
		<h3>입력된 member가 없습니다</h3>
	</c:if>
	<c:if test="${list.size() != 0 }">
		<c:forEach var="member" items="${list }">
			<h3>ID : ${member.id }</h3>
			<h3>PW : ${member.pw }</h3>
		</c:forEach>
		<h4>이상 ${list.size() }명입니다</h4>
	</c:if>
	<hr>
	<h3><span onclick="location.href='${conPath}/'">메인 페이지로 가기</span></h3>
</body>
</html>