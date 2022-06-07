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
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		request.setCharacterEncoding("utf-8"); 
		int num = Integer.parseInt(request.getParameter("num"));
		String pw = request.getParameter("pw");
		String pageNum = request.getParameter("pageNum");
		BoardDao dao = BoardDao.getInstance();
		int result = BoardDao.FAIL;	
		if(dto!=null){
			result = dao.DeleteBoard(num, pw);
			if(result == BoardDao.SUCCESS){%>
				<script>
					alert('글 삭제 완료');
					location.href = 'list.jsp?pageNum=<%=pageNum%>';
				</script>
		<%} else {%>
			<script>
				alert('비밀번호 오류');
				history.back();
			</script>
<%		}
	}%>
	
</body>
</html>