<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>컨텍스트 path : <%=conPath %></h2>
	<hr>
	<a href="<%=conPath %>/Ex3">Ex3 서블릿</a><br>
	<!-- <a href="../Ex3">Ex3 서블릿</a><br>
	<a href="/ch05_jsp/Ex3">Ex3 서블릿</a><br> -->
	<button onclick = "location.href='<%=conPath %>/Ex3'">Ex3서블릿</button>
</body>
</html>