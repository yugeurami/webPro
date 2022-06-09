<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
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
		int bid = Integer.parseInt(request.getParameter("bid"));
		String pageNum = request.getParameter("pageNum");
		BookDao dao = BookDao.getInstance();
		BookDto book = dao.getBook(bid);
	%>
	<table>
		<caption>[<%=book.getBtitle() %>] 세부 정보</caption>
		<tr>
			<td rowspan="3">
				<img src="<%=conPath %>/bookImg/<%=book.getBimg1() %>">
			</td>
			<td><%=book.getBtitle() %></td>
		</tr>
		<tr>
			<td>
				<%if(book.getBdiscount()==0){%>
						<%=book.getBprice() %>원<br>
					<%}else {%>
						<del><%=book.getBprice() %></del><br>
						<%=book.getBprice()*(100-book.getBdiscount())/100 %>원<br>
						<b><%=book.getBdiscount() %>% 할인</b>
					<%} %>
			</td>
		</tr>
		<tr>
			<td>
				<button>구매</button>
				<button onclick="location='ex3_list_productp.jsp?pageNum=<%=pageNum%>'">목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="<%=conPath %>/bookImg/<%=book.getBimg2() %>"><br>
				<pre><%=book.getBcontent() %></pre>
			</td>
		</tr>
	</table>
</body>
</html>