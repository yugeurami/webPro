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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa")){
			if(pw!=null && pw.equals("111")){
				session.setAttribute("id", id);
				session.setAttribute("name", "홍길동");
				response.sendRedirect("main.jsp");
			}else{
				response.sendRedirect("login.jsp?msg=pw");							
			}
		}else{
			response.sendRedirect("login.jsp?msg=id");
		}
	%>
</body>
</html>