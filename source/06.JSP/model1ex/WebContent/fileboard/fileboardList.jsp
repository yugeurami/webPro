<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.FileboardDao"%>
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
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		FileboardDao dao = FileboardDao.getInstance();
		ArrayList<FileboardDto> dtos = dao.fileboardList(startRow, endRow);
	%>
	<jsp:include page="../main/header.jsp"/>
	<table>
		<tr>
			<td colspan="7">
			<%
				CustomerDto customer = (CustomerDto)session.getAttribute("customer");
				if(customer==null){
			%>
					<button onclick="location.href='write.jsp'">글쓰기</button>
			<%
				}
			%>
			</td>
		</tr>
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>메일</td>
			<td>IP</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<%
			for(int i = 0 ; i<dtos.size() ; i++){
		%>
				<tr>
					<td><%=dtos.get(i).getFnum() %></td>
					<td><%=dtos.get(i).getCname() %></td>
					<td><%=dtos.get(i).getFsubject() %></td>
					<td><%=dtos.get(i).getCemail() %></td>
					<td><%=dtos.get(i).getFip() %></td>
					<td><%=dtos.get(i).getFrdate() %></td>
					<td><%=dtos.get(i).getFhit() %></td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>