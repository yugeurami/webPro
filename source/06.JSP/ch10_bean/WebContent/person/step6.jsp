<%@page import="com.lec.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<jsp:useBean class="com.lec.ex.Person" id="p" scope="request"/>
<jsp:setProperty property="*" name="p"/>
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