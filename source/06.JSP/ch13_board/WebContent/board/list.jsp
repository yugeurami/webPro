<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
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
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath%>writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>메일</th>
			<th>조회수</th>
		</tr>
		<%
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt();
			if(totalCnt==0){
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");				
			}else{
				ArrayList<BoardDto> dtos = dao.listBoard();
				for(BoardDto dto : dtos){
					out.println("<tr>");
					out.println("<td>"+dto.getNum()+"</td>");
					if(dto.getReadcount()>10){
						out.println("<td class='left'><img src='"+conPath+"/img/hot.gif'><a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+"'>"+dto.getSubject()+"</a></td>");										
					}else{
						out.println("<td class='left'><a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+"'>"+dto.getSubject()+"</a></td>");
					}
					out.println("<td>"+dto.getWriter()+"</td>");
					out.println("<td>"+ (dto.getEmail()!= null ? dto.getEmail() : " ") +"</td>");
					out.println("<td>"+dto.getReadcount()+"</td>");
					out.println("</tr>");
				}				
			}
		%>
	</table>
</body>
</html>