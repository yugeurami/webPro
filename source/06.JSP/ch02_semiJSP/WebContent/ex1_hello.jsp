<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hello, world</h1>
	<% //자바 파일
		int total = 0;
		for(int i = 1 ; i<=100 ; i++){
			total += i;
		}
	%>
	<h2>1부터 100까지 누적 합은 <%=total%>입니다</h2>
</body>
</html>