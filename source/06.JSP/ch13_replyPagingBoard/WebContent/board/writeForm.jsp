<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
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
		int num = 0;
		BoardDto dto = new BoardDto();
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum==null){
			pageNum = "1";
		}
		if(request.getParameter("num")!=null){ //답변글을 위해 들어왔다면 원글의 정보를 dto에
			num = Integer.parseInt(request.getParameter("num"));
			BoardDao dao = BoardDao.getInstance();
			dto = dao.getBoardOneLine(num); // 원글에 대한 정보 가져오기
		}		
	%>
	<form action="writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="ref" value="<%=dto.getRef()%>">
		<input type="hidden" name="re_step" value="<%=dto.getRe_step()%>">
		<input type="hidden" name="re_indent" value="<%=dto.getRe_indent()%>">
		<table>
			<caption>게시판</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required" 
						value="<%if(dto.getSubject()!=null){
									out.println("답 : " + dto.getSubject());	
								}%>"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea name="content" rows="5" cols="5" required="required"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록으로" class="btn" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>