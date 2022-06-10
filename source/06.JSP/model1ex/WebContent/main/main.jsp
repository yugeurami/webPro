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
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 5;
		final int BLOCKSIZE = 2;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		CustomerDao dao = CustomerDao.getInstance();
		ArrayList<CustomerDto> customers = dao.customerList(startRow, endRow);
	%>
	<jsp:include page="../main/header.jsp"/>
		<div id="mainForm_wrap">
		<table>
			<tr>
				<td>회원ID</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>주소</td>
			</tr>
		<%
			for(int i = 0 ; i<customers.size() ; i++){
		%>
			<tr>
				<td><%=customers.get(i).getCid() %></td>
				<td><%=customers.get(i).getCpw() %></td>
				<td><%=customers.get(i).getCname() %></td>
				<td><%=customers.get(i).getCemail() == null ? "-" : customers.get(i).getCemail()%></td>
				<td><%=customers.get(i).getCaddress() == null ? "-" : customers.get(i).getCaddress()%></td>
			</tr>
		<%	} %>
		</table>
		<div class="paging">
			<%
				int customerCnt = dao.customerCnt();
				int pageCnt = (int)Math.ceil((double)(customerCnt)/PAGESIZE);
				int startPage = ((currentPage-1)/BLOCKSIZE)* BLOCKSIZE + 1; 
				int endPage = startPage + BLOCKSIZE - 1;
				if(endPage > pageCnt){
					endPage = pageCnt;
				}
				if(startPage > BLOCKSIZE){
			%>
					[ <a href="main.jsp?pageNum=<%= startPage-1 %>">이전</a> ]		
			<%
				}
				for(int i = startPage ; i<=endPage ; i++){
					if(i==currentPage){
						out.println("[ <b>"+i+"</b> ]");
					}else{
						out.println("[ <a href='main.jsp?pageNum="+i+"'>"+i+"</a> ]");
					}
				}
				if(endPage<pageCnt){
			%>
					[ <a href="main.jsp?pageNum=<%= endPage+1 %>">다음</a> ]		
			<%		
				}
			%>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>