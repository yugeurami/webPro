<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
	<%  request.setCharacterEncoding("utf-8");
		String pwStr = request.getParameter("pw");
		String pw = "";
		for(int i = 0; i<pwStr.length(); i++){
			pw += "*";
		}
		String birth = request.getParameter("birth");
		Timestamp birth2 = Timestamp.valueOf(birth+" 00:00:00");
		String[] hobby = request.getParameterValues("hobby");
		String msgHobby = "";
		for(int j = 0; j<hobby.length; j++) {
			if(j == hobby.length-1) {
				msgHobby += hobby[j];
			}else {
				msgHobby += hobby[j]+", ";
			}
		}
		String[] mailSend = request.getParameterValues("mailSend");
		String msgMail = "";
		if(mailSend!=null) {
			for(int j = 0; j<mailSend.length; j++) {
				if(j == mailSend.length-1) {
					msgMail += mailSend[j];
				}else {
					msgMail += mailSend[j]+", ";
				}
			}
		} else {
			msgMail += "모두 수신 거부";
		}
		Date date = new Date(System.currentTimeMillis());
	%>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입정보</div>
			<h3>name : <%=request.getParameter("name") %></h3>
			<h3>id : <%=request.getParameter("id") %></h3>
			<h3>pw : <%=pw %></h3>
			<h3>birth : <%=birth%></h3>
			<h3>birth2 : <%=birth2%></h3>
			<h3>hobby : <%=msgHobby%></h3>
			<h3>gender : <%=request.getParameter("gender") %></h3>
			<h3>email : <%=request.getParameter("email") %></h3>
			<h3>mailSend : <%=msgMail%></h3>
			<h3>가입일 : <%=date%></h3>
			<h3>가입IP : <%=request.getRemoteAddr() %></h3>
	</div>
	<%@ include file="../exam2/footer.jsp"%>
</body>
</html>