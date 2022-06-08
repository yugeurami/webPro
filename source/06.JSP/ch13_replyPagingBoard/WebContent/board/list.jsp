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
		<tr><td><a href="writeForm.jsp">글쓰기</a></td></tr>
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
			int totalCnt = dao.getBoardTotalCnt(); // DB에 저장된 글 갯수
			
			final int PAGESIZE = 10;
			final int BLOCKSIZE = 10;
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null) {
				pageNum = "1"; // 전달 받은 pageNum 파라미터가 없으면 1페이지로 셋팅
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1)*PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			
			if(totalCnt==0){
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");				
			}else{
				// list.jsp 또는 list.jsp?pageNum=11 또는 list.jsp?pageNum=1
				ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow);
				for(BoardDto dto : dtos){
					out.println("<tr>");
					out.println("<td>"+dto.getNum()+"</td>");
					out.println("<td class='left'>");
					// 조회수가 10 초과 시
					if(dto.getReadcount()>10){
						out.println("<img src='"+conPath+"/img/hot.gif'>");		
					}
					// 답변글일 경우
					if(dto.getRe_indent()>0){
						int width = (dto.getRe_indent()-1) * 10; 
						for(int i = 1; i<=dto.getRe_indent(); i++){
							out.println("<img src='"+conPath+"/img/level.gif' width='"+width+"' height='10'>");
						}
						out.println("<img src='"+conPath+"/img/re.gif' width='10' height='10'>");
					}
					out.println("<a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+"&pageNum="+pageNum+"'>"+dto.getSubject()+"</a></td>");
					out.println("<td>"+dto.getWriter()+"</td>");
					out.println("<td>"+ (dto.getEmail()!= null ? dto.getEmail() : " ") +"</td>");
					out.println("<td>"+dto.getReadcount()+"</td>");
					out.println("</tr>");
				}				
			}
		%>
	</table>
	<div class="paging">
		<%
			int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE); // 페이지 갯수(다음 블럭 여부)
			int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
			int endPage = startPage + BLOCKSIZE-1;
			if(endPage>pageCnt){
				endPage = pageCnt;
			}
			if(startPage > BLOCKSIZE){ // 이전 페이지가 있다 = 스타트  페이지가 블록 사이즈보다 크다!
				out.println("[ <a href='list.jsp?pageNum="+(startPage-1)+"'>이전</a> ]");	
			}
			for(int i = startPage ; i<=endPage ; i++){
				if(i==currentPage){ // 현재 페이지면 눌리지 않게!
					out.println("[ <b>"+i+"</b> ]");
				} else{
					out.println("[ <a href='list.jsp?pageNum="+ i +"'>"+ i +"</a> ]");					
				}
			}
			if(endPage < pageCnt){
				out.println("[ <a href='list.jsp?pageNum="+(endPage+1)+"'>다음</a> ]");
			}
		%>
	</div>
</body>
</html>