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
	<h2>ex2_view.jsp 파일입니다</h2>
	<h2>회원정보</h2>
	<h3>ID : ${member.id }</h3>
	<h3>PW : ${member.pw }</h3>
	<h3>가입일 : ${member.rdate }</h3>
	<br>
	<h3>ID : ${param.id }</h3>
	<h3>PW : ${param.pw }</h3>	
	<button onclick="history.go(-1)">이전</button>
</body>
</html>