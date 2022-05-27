<%@page import="com.lec.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<jsp:useBean class="com.lec.ex.Person" id="p" scope="request"/>
<jsp:setProperty property="name" name="p" param="name"/>
<jsp:setProperty property="age" name="p" param="age"/>
<jsp:setProperty property="gender" name="p" param="gender"/>
<jsp:setProperty property="address" name="p" param="address"/>
<jsp:forward page="pView.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
</body>
</html>