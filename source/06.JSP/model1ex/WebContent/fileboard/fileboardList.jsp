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
		final int BLOCKSIZE = 5;
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
				if(customer!=null){
			%>
					<button onclick="location.href='writeForm.jsp?pageNum=<%=pageNum%>'">글쓰기</button>
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
				<tr onclick="location.href='content.jsp?pageNum=<%=pageNum%>&fnum=<%=dtos.get(i).getFnum()%>'">
					<td>
		<%		
				if(dtos.get(i).getFre_step()>0){
					for(int j = 0 ; j<dtos.get(i).getFre_step() ; j++){
						out.println("&nbsp");
					}
						out.println("└");
				}
		%>
					<%=dtos.get(i).getFnum() %></td>
					<td><%=dtos.get(i).getCname() %></td>
					<td>
						<% if(dtos.get(i).getFhit()>10) { %>
								<img src="../img/hot.gif">
						<% } %>
						<%=dtos.get(i).getFsubject() %>
						<%
							if(dtos.get(i).getFfilename()!=null){
						%>
								<img src="../img/fileup.jpg" alt="첨부파일" width="12">
						<%		
							}
						%>
					</td>
					<td><%=dtos.get(i).getCemail()==null ? "-" : dtos.get(i).getCemail() %></td>
					<td><%=dtos.get(i).getFip() %></td>
					<td><%=dtos.get(i).getFrdate() %></td>
					<td><%=dtos.get(i).getFhit() %></td>
				</tr>
		<%
			}
		%>
	</table>
	<div class="paging">
		<%
			int bookTotalCnt = dao.fileboardCnt();
			int pageCnt = (int)Math.ceil((double)(bookTotalCnt)/PAGESIZE);
			int startPage = ((currentPage-1)/BLOCKSIZE)* BLOCKSIZE + 1; 
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
			if(startPage > BLOCKSIZE){
		%>
				[ <a href="fileboardList.jsp?pageNum=<%= startPage-1 %>">이전</a> ]		
		<%
			}
			for(int i = startPage ; i<=endPage ; i++){
				if(i==currentPage){
					out.println("[ <b>"+i+"</b> ]");
				}else{
					out.println("[ <a href='fileboardList.jsp?pageNum="+i+"'>"+i+"</a> ]");
				}
			}
			if(endPage<pageCnt){
		%>
				[ <a href="fileboardList.jsp?pageNum=<%= endPage+1 %>">다음</a> ]		
		<%		
			}
		%>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>