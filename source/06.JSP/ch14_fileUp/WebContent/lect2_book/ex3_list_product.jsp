<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
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
		BookDao dao = BookDao.getInstance();
		ArrayList<BookDto> books = dao.listBook();
	%>
	<table>
		<caption>도서 리스트</caption>
		<tr>
		<%
			for(int i = 0 ; i<books.size() ; i++){
		%>
			<td>
				<img src="<%=conPath %>/bookImg/<%=books.get(i).getBimg1() %>" alt="대표"><br>
				<%=books.get(i).getBtitle() %><br>
				<del><%=books.get(i).getBprice() %></del><br>
				<%=books.get(i).getBprice()*(100-books.get(i).getBdiscount())/100 %>원<br>
			</td>

		<%	
				if(i%3==2) out.println("</tr><tr>");
			}
		%>
		</tr>
	</table>
</body>
</html>