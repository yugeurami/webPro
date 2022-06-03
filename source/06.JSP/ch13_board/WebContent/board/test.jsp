<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
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
	<a href = "xx.jsp">xx</a>
	<%-- <%
		BoardDao bDao = BoardDao.getInstance();
		out.println("<h2>1. DB 글 갯수 : " + bDao.getBoardTotalCnt() + "입니다</h2>"); 
		out.println("<h2>2. 글목록</h2>");
		ArrayList<BoardDto> dtos = bDao.listBoard();
		for(BoardDto dto : dtos){
			out.println(dto+"<br>");
		}
		out.println("<h2>3. 글 생성</h2>");
		BoardDto dto = new BoardDto(0, "김길동", "글입니다", "본문\n입니다", "kim@k.com", 0, "1", 0, 0, 0, "127.0.0.2", null);
		int result = bDao.insertBoard(dto);
		out.println(result == BoardDao.SUCCESS ? "글쓰기 성공" : "글쓰기 실패");
		out.println("<h2>4. 글 가져오기 + 5. 조회수 올리기</h2>");
		bDao.readcountUp(7);
		dto = bDao.getBoardOneLine(7);
		out.println("수정전의 7번 글 : " + dto);
		out.println("<h2>6. 글 수정</h2>");
		dto.setSubject("바뀐 제목xxxx");
		dto.setContent("바뀐 본문yyyy");
		result = bDao.updateBoard(dto);
		if(result==BoardDao.SUCCESS){
			dto = bDao.getBoardOneLine(7);
			out.println("수정 후의 7번 글 : " + dto);
		}else{
			out.println("수정 실패");
		}
		out.println("<h2>7. 글 삭제</h2>");
		result = bDao.DeleteBoard(11, "1");
		out.println(result == BoardDao.SUCCESS ? "글삭제 성공" : "글삭제 실패");
		
	%> --%>
</body>
</html>