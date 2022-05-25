<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("cookieName", "cookieValue"); // 쿠키 생성
		cookie.setMaxAge(60*60); // 1시간 유효한 쿠키(초단위) -1을 넣으면 쿠키를 삭제하기 전까지 유효하다
		response.addCookie(cookie); // response에 탑재
	%>
	<h2>지금 막 생성된 쿠키 이름 : <%= cookie.getName() %></h2>
	<h2>지금 막 생성된 쿠키 값 : <%= cookie.getValue() %></h2>
	<hr>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름-쿠키값) 리스트 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름 cookieName)찾기</a><br>
	<a href="ex4_cookieDel.jsp">쿠키 삭제</a>
</body>
</html>