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
				String name = (String)session.getAttribute("name");
				if(name==null){
			%>
				<li><a href="<%=conPath %>/member/login.jsp">login</a></li>
				<li><a href="<%=conPath %>/member/join.jsp">join</a></li>					
				<li><a href="<%=conPath %>/member/main.jsp">home</a></li>					
			<%}else{ %>
				<li><a href="<%=conPath %>/member/logout.jsp">logout</a></li>			
				<li><a href="<%=conPath %>/member/joinPro.jsp">my page</a></li>			
				<li><a href="<%=conPath %>/member/main.jsp"><%=name %>님</a></li>			
			<%} %>
		</ul>
	</header>
</body>
</html>