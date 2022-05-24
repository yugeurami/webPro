<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>동전이 있는 곳을 맞춰봐</title>
	<link href="<%=conPath %>/css/ex1.css" rel="stylesheet">
</head>
<body>
	<div>
		<h2>동전이 있는 곳을 맞춰보세요</h2>
		<form action="<%=conPath %>/exam1/exPro.jsp">
			<button name="btn" value="1">1번</button>
			<button name="btn" value="2">2번</button>
			<button name="btn" value="3">3번</button>
		</form>
	</div>
	<div id="msg">
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.print(msg);
		}
	%>
	</div>
</body>
</html>