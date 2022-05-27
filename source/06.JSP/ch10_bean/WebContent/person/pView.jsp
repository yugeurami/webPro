<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 뷰단 -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<h2>입력된 개인정보</h2>
	<p>이름 : <jsp:getProperty property="name" name="p"/> </p>
	<p>나이 : <jsp:getProperty property="age" name="p"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="p"/></p>
	<p>성별 : <jsp:getProperty property="address" name="p"/></p>	
</body>
</html>