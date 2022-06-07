<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String num = request.getParameter("num"); 
		String pageNum = request.getParameter("pageNum");
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = dao.getBoardOneLine(num);
	%>
	<form action="updatePro.jsp?pageNum=<%=pageNum%>" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<table>
			<caption><%=num %>번 글 수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" readonly="readonly" value="<%=dto.getWriter()%>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required" value="<%= dto.getSubject()%>"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="<%=dto.getEmail()!=null ? dto.getEmail() : ""%>"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><pre></pre><textarea name="content" rows="5" cols="5" required="required"><%=dto.getContent() %></textarea><pre></pre></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required" value="<%=dto.getPw()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록으로" class="btn" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>