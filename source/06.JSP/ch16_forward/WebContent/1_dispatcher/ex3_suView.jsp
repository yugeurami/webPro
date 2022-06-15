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
	<h1>ex3_suView.jsp 페이지 입니다</h1>
	<h2>1부터 ${param.su }까지 누적합은 ${sum }입니다</h2>
	<button onclick="history.back()">이전</button>
	<button onclick="location='1_dispatcher/ex3_suInput.jsp'">다시</button>
</body>
</html>