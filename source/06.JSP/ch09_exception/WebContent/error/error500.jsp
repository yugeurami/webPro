<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%@ page isErrorPage="true" %> <!-- exception 내부 객체를 사용하기 위함 -->
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>본 페이지는 공사중입니다. 빠른 시일 내로 복구하겠습니다</h2>
	<h4>관리자 문의 : hong@hong.com</h4>
	<%
		System.out.println("예외 메세지 : " +exception.getMessage());
		System.out.println("에러 타입 : " +exception.getClass().getName());
	%>
</body>
</html>