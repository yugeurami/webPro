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
	<h2>표현식 태그 이용</h2>
	<h4>산술 연산</h4>
	<p>10 + 1 = <%= 10+1 %><br>
	10 / 0.0 = <%=10/0.0 %></p> <!-- 0으로 나누면 에러, 0.0으로 나누면 무한대 -->
	<h4>관계 연산</h4>
	<p>1 == 2 => <%=1==2 %><br>
	1 != 2 => <%=1!=2 %><br>	  
	1 &lt; 2 => <%=1<2 %></p>	  
	<h4>조건 연산</h4>
	<p><%= 1>2 ? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다" %></p>
	<h4>논리연산</h4>
	<p>( 1 > 2 ) || ( 1 &lt; 2 ) =  <%= (1>2) || (1<2) %></p>
	<h4>로그인여부</h4>
	<p> <%=session.getAttribute("customer") == null ? "로그인 전" : "로그인 후" %><br>
	<%=session.getAttribute("customer") != null ? "로그인 후" : "로그인 전" %></p>
	<h4>pageNum 파라미터 여부</h4>
	<p><%=request.getParameter("pageNum") == null ? "pageNum 안 옴" : "pageNum 옴" %></p>
	<h4>name 파라미터</h4>
	<p><%=request.getParameter("name")%></p>
<%-- 	<p>대문자로 : <%=request.getParameter("name").toUpperCase()%></p> 이 페이지 부터 실행하면 당연히 에러가 남--%>
	<hr>
	<h2>EL표기법 이용(표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h2>
	<h4>산술 연산</h4>
	<p>10 + 1 = ${ 10+1 }<br>
		10 / 0.0 = ${10/0.0 }</p> <!-- 0으로 나누면 에러, 0.0으로 나누면 무한대 -->
	<h4>관계 연산</h4>
	<p>1 == 2 => ${1==2 }<br>
	1 == 2 => ${1 eq 2 }<br>
	1 != 2 => ${1!=2 }<br>	  
	1 &lt; 2 => ${1<2 }</p>	  
	<h4>조건 연산</h4>
	<p>${ 1>2 ? "1이 2보다 큽니다" : "1이 2보다 크지 않습니다" }</p>
	<h4>논리연산</h4>
	<p>( 1 > 2 ) || ( 1 &lt; 2 ) =  ${(1>2) || (1<2) }</p>
	<h4>로그인여부</h4>
	<p> ${customer == null ? "로그인 전" : "로그인 후" }<br>
		${customer eq null ? "로그인 전" : "로그인 후" }<br>
		${empty customer ? "로그인 전" : "로그인 후" }<br>
		${not empty customer ? "로그인 후" : "로그인 전" }</p>
	<h4>pageNum 파라미터 여부</h4>
	<p>${empty param.pageNum ? "pageNum 안 옴" : "pageNum 옴" }</p>
	<h4>name 파라미터</h4>
	<p>${param.name }<br>
	파라미터를 대문자로 : ${param.name.toUpperCase() }</p> <!-- 해당 파라미터가 없어도 예외 발생 안함 -->
</body>
</html>