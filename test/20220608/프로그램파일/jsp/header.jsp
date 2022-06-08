<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&display=swap');
	</style>
	<link href="<%=conPath %>/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<ul>
			<% 
				CustomerDto customer = (CustomerDto)session.getAttribute("customer");
				if(customer==null){
			%>
				<li><a href="<%=conPath %>/customer/login.jsp">login</a></li>
				<li><a href="<%=conPath %>/customer/join.jsp">join</a></li>					
				<li><a href="<%=conPath %>/customer/main.jsp">home</a></li>					
			<%}else{ %>
				<li><a href="<%=conPath %>/customer/logout.jsp">logout</a></li>			
				<li><a href="<%=conPath %>/customer/modify.jsp">modify</a></li>			
				<li><a href="<%=conPath %>/customer/main.jsp"><%=customer.getCname() %>님</a></li>			
			<%} %>
		</ul>
	</header>
</body>
</html>