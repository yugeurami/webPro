<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/main.css" rel="stylesheet">
</head>
<body>
	<%
		CustomerDto name = (CustomerDto)session.getAttribute("customer");		
		if(session.getAttribute("customer")!=null){
			session.invalidate();
			response.sendRedirect("main.jsp");
		}
	%>
</body>
</html>