<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="ex1.css" rel="stylesheet">
</head>
<body>
	<div>
	<%
		Random random = new Random();
		int cNum = random.nextInt(4);
		int pNum = Integer.parseInt(request.getParameter("btn"));
		if(cNum==pNum){
			out.println("<p>정답입니다</p>동전이 있는 곳은 "+cNum+"<br>");
		}else{
			String msg = "<p>Wrong! Try Again!</p><p>(" + pNum+ "은(는) 아니고 정답은"+cNum+")";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("ex.jsp?msg="+msg);
		}
	%>
	<button name="return" onclick="history.go(-1);">다시 도전</button>
	</div>
</body>
</html>