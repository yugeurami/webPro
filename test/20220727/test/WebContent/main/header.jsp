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
		<div class="title">
			<span>어플리케이션 배포</span>
		</div>
		<div class="nav">
			<ul>				
				<li><a href="<%=conPath %>/member/join.jsp">회원등록</a></li>
				<li><a href="<%=conPath %>/member/list.jsp">회원조회/수정</a></li>			
				<li><a href="<%=conPath %>/money/list.jsp">매출조회(회원/제품)</a></li>			
				<li><a href="<%=conPath %>/main/main.jsp">홈으로</a></li>			
			</ul>
		</div>
	</header>
</body>
</html>