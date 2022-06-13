<%@page import="com.lec.dto.CustomerDto"%>
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
		<div class="nav">
			<ul>
				<% 
					CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					if(customer==null){
				%>
					<li><a href="<%=conPath %>/fileboard/fileboardList.jsp">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/join.jsp">회원가입</a></li>					
					<li><a href="<%=conPath %>/customer/login.jsp">로그인</a></li>					
				<%}else{ %>
					<li><a href="<%=conPath %>/fileboard/fileboardList.jsp">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/logout.jsp">로그아웃</a></li>			
					<li><a href="<%=conPath %>/customer/modify.jsp">정보수정</a></li>			
					<li><a href="<%=conPath %>/main/main.jsp"><%=customer.getCname() %>님</a></li>			
				<%} %>
			</ul>
		</div>
		<div class="logo">
			<a href="<%=conPath %>/main/main.jsp"><img src="https://pbs.twimg.com/profile_images/1268740402074419200/uxhIWach_400x400.png"></a>
		</div>
		<div id="lnb">
			<ul>
				<% 
					if(customer==null){
				%>
					<li><a href="<%=conPath %>/book/book_list.jsp">도서보기</a></li>
				<%}else{ %>
					<li><a href="<%=conPath %>/book/book_list.jsp">도서보기</a></li>
					<li><a href="<%=conPath %>/book/bookRegisterForm.jsp">도서등록</a></li>			
				<%} %>
			</ul>
		</div>
	</header>
</body>
</html>