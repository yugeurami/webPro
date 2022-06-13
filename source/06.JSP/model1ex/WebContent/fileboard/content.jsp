<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileboardDto"%>
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
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao dao = FileboardDao.getInstance();
		dao.hitUp(fnum);
		FileboardDto dto = dao.getFileboard(fnum);
	%>
	<table>
		<caption>글 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td><%=fnum %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%= dto.getFsubject() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=dto.getCname() %>(<%=dto.getCid() %>)</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><%=dto.getFfilename()==null ? "파일을 첨부하지 않았습니다" : dto.getFfilename() %></td>
		</tr>
		<tr>
			<th>본문</th>
			<td><pre><%=dto.getFcontent()==null ? "" : dto.getFcontent()  %></pre></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=dto.getFrdate() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=dto.getFhit() %></td>
		</tr>
		<tr>
			<th>IP</th>
			<td><%=dto.getFip() %></td>
		</tr>
		<tr>
			<td colspan="2">
			<button onclick="location.href='fileboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
		<%
			CustomerDto customer = (CustomerDto)(session.getAttribute("customer"));
			if(customer!=null){
				if(customer.getCid().equals(dto.getCid())){
		%>
					<button onclick="location.href='updateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">글 수정</button>
		<%
				}	
		%>
				<button onclick="location.href='replyForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">답변</button>
		<%
			}
		%>
				<button onclick="location.href='deleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">글 삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>