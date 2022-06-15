<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>변수 선언과 출력</h2>
	<c:set var="varName" value="varValue"/>
	varName : ${varName }<br>
	<c:set var="varName" value="abc <varValue>"/>
	varName : ${varName }<br>
	varName : <c:out value="${varName}" escapeXml="true"/><br> <!-- escapeXml="true" 특수 문자 인식 -->
	<h2>변수 삭제</h2>
	<c:remove var="varName"/>
	varName : ${varName }<br>
	varName : ${empty varName ? "삭제됨" : "남아있음" }<br>
	varName : <c:out value="${varName}" default="없어진 변수"/><br>
</body>
</html>