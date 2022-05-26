<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="nav">
			<%
				String id = null;
				Cookie[] cs = request.getCookies();
				if(cs!=null){
					for(Cookie c : cs){
						if(c.getName().equals("id")){
							id = c.getValue();
							break;
						}
					}
				}
			%>
			<%if(id==null){ //로그인 전%>
				<ul>
					<li><a href="join.jsp">회원가입</a></li>
					<li><a href="login.jsp">로그인</a></li>
					<li><a href="main.jsp">홈</a></li>
				</ul>
			<%}else{//로그인 후 %>
				<ul>
					<li><a href="logout.jsp">로그아웃</a></li>
					<li><a href="clist.jsp">쿠키리스트</a></li>
					<li><a href="#"><%=id %>님</a></li>
				</ul>				
			<%} %>
		</div>
	</header>
</body>
</html>