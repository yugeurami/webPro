<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="ex02_scope.jsp">
		<p>이름 : <input type="text" name="name"></p>
		<p>ID : <input type="text" name="id"></p>
		<p><input type="submit"></p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue");
		session.setAttribute("sessionName", "sessionValue");	
		application.setAttribute("applicationName", "applicationValue");
		//forward 할 객체(dispatcher)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa");
		dispatcher.forward(request, response); /* forward 하는 거랑 같음 */
	%>
	<h3>페이지 내 속성 변수 값 : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 내 속성 변수 값 : <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 속성 변수 값 : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 속성 변수 값 : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h2>EL표기법으로 변경</h2>
	<h3>페이지 내 속성 변수 값 : ${pageScope.pageName }</h3>
	<h3>request 내 속성 변수 값 : ${requestScope.requestName }</h3>
	<h3>session 내 속성 변수 값 : ${sessionScope.sessionName }</h3>
	<h3>application 내 속성 변수 값 : ${applicationScope.applicationName }</h3>
	<hr>
	<h3>페이지 내 속성 변수 값 : ${pageName }</h3>
	<h3>request 내 속성 변수 값 : ${requestName }</h3>
	<h3>session 내 속성 변수 값 : ${sessionName }</h3>
	<h3>application 내 속성 변수 값 : ${applicationName }</h3>
</body>
</html>