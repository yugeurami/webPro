<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="java.util.ArrayList"%>
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
	<jsp:include page="../main/header.jsp"/>
	<%
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3;
		final int BLOCKSIZE = 4;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BookDao dao = BookDao.getInstance();
		ArrayList<BookDto> books = dao.listBook(startRow, endRow);
	%>
	<table>
		<caption>도서 리스트</caption>
		<tr>
		<%
			for(int i = 0 ; i<books.size() ; i++){
		%>
			<td>
				<a href="ontent.jsp?bid=<%=books.get(i).getBid()%>&pageNum=<%=pageNum%>">
					<img src="<%=conPath %>/bookImg/<%=books.get(i).getBimg1() %>" alt="대표"><br>
					<%=books.get(i).getBtitle() %><br>
					<%if(books.get(i).getBdiscount()==0){%>
						<%=books.get(i).getBprice() %>원<br>
					<%}else {%>
						<del><%=books.get(i).getBprice() %></del><br>
						<%=books.get(i).getBprice()*(100-books.get(i).getBdiscount())/100 %>원<br>
					<%} %>
				</a>
			</td>

		<%	
			}
		%>
		</tr>
	</table>
	<div class="paging">
		<%
			int bookTotalCnt = dao.bookTotCnt();
			int pageCnt = (int)Math.ceil((double)(bookTotalCnt)/PAGESIZE);
			int startPage = ((currentPage-1)/BLOCKSIZE)* BLOCKSIZE + 1; 
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
			if(startPage > BLOCKSIZE){
		%>
				[ <a href="book_list.jsp?pageNum=<%= startPage-1 %>">이전</a> ]		
		<%
			}
			for(int i = startPage ; i<=endPage ; i++){
				if(i==currentPage){
					out.println("[ <b>"+i+"</b> ]");
				}else{
					out.println("[ <a href='book_list.jsp?pageNum="+i+"'>"+i+"</a> ]");
				}
			}
			if(endPage<pageCnt){
		%>
				[ <a href="book_list.jsp?pageNum=<%= endPage+1 %>">다음</a> ]		
		<%		
			}
		%>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>