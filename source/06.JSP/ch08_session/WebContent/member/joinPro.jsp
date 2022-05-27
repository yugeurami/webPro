<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&family=Noto+Sans+KR:wght@300&display=swap');
	</style>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String hidden = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Date date = new Date(System.currentTimeMillis());
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if(!birthStr.equals("")){
			birth = Date.valueOf(request.getParameter("birth"));
		}
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		session.setAttribute("id", id);
	%>
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입</div>
			<table>
				<tr>
					<td>hidden : </td>
					<td><%=hidden %></td>
				</tr>
				<tr>
					<td>name : </td>
					<td><%=name %></td>
				</tr>
				<tr>
					<td>id : </td>
					<td><%=id %></td>
				</tr>
				<tr>
					<td>pw : </td>
					<td><% for(int i = 0 ; i<pw.length(); i++){
						out.print("*");
					} %></td>
				</tr>
				<tr>
					<td>birth : </td>
					<td><%=birth %></td>
				</tr>
				<tr>
					<td>hobby : </td>
					<td>
						<% if(hobby!=null){
							for(String s : hobby)
							out.println(s);	
						}%>
					</td>

				</tr>
				<tr>
					<td>gender : </td>
					<td><%=gender %></td>
				</tr>
				<tr>
					<td>email : </td>
					<td><%=email %></td>
				</tr>
				<tr>
					<td>mailSend : </td>
					<td><%=(mailSend!=null)? Arrays.toString(mailSend) : "모두 수신 거부" %></td>
				</tr>
			</table>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>