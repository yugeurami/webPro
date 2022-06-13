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
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		FileboardDao dao = FileboardDao.getInstance();
		FileboardDto dto = dao.getFileboard(fnum);
	%>
	<jsp:include page="../main/header.jsp"/>
	<form action="updatePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="fnum" value="<%=fnum%>">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="dbfile" value="<%=dto.getFfilename()%>">
		<table>
			<caption><%=fnum %>번 글 수정</caption>
			<tr>
				<th>글제목</th>
				<td>
					<input type="text" name="fsubject" required="required" value="<%=dto.getFsubject()%>">
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="file" style="width:30%"><%=dto.getFfilename()!=null ? dto.getFfilename() : "첨부파일 없음" %>
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea rows="5" cols="20" name="fcontent"><%=dto.getFcontent()%></textarea>
				</td>
			</tr>
			<tr>
				<th>글 삭제용 비밀번호</th>
				<td>
					<input type="password" name="fpw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글등록" class="btn">
					<input type="reset" value="취소" class="btn">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>