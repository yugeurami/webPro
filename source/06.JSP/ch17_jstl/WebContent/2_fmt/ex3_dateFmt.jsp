<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<body>
	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowDateUtil" value="<%=new java.util.Date() %>"/>
	${nowDate }<br>
	${nowTimes }<br>
	${nowDateUtil }
	<hr>
	<h3>날짜만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/><br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/><br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/>
	<hr>
	<h3>시간만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/><br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/><br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/>
	<hr>
	<h3>날짜와 시간 모두 출력</h3>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/><br>
	<fmt:formatDate value="${nowTimes }" pattern="yyyy년MM월dd일(E요일) hh:mm:ss:SS(a)"/><br>
	<fmt:formatDate value="${nowDateUtil }" pattern="yy-MM-dd(E) HH:mm:ss:SS(a)"/><br>
</body>
</html>