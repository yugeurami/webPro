<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
	
</head>
<body>
	<%
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int fnum = Integer.parseInt(request.getParameter("fnum"));
	%>
	<jsp:include page="../main/header.jsp"/>
	<form action="deletePro.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>" method="post">
		<table>
			<tr>
				<th>비밀번호 입력</th>
				<td>
					<input type="password" name="fpw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글 삭제" class="btn">
					<input type="button" onclick="history.back(-1)" value="뒤로가기" class="btn">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>