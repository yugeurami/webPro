<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% //세션에 속성추가 (객체 타입으로 추가)
		session.setAttribute("sessionName", "sessionValue");
		session.setAttribute("myNum", 123);
		// session.setArribute("myNum", new Integer(123))으로 바껴서 들어감
	%>
	<h1>세션에 sessionName 속성 추가</h1>
	<h1>세션에 myNum 속성 추가</h1>
	<a href="ex2_sessionGet.jsp">세션 GET</a>
</body>
</html>