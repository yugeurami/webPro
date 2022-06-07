<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr()); //요청한 곳의 주소(ip) 불러옴
		BoardDao dao = BoardDao.getInstance();
		int result = dao.insertBoard(dto);
		if(result == BoardDao.SUCCESS){%>
			<script>
				alert('글쓰기 완료');
				location.href = 'list.jsp';
			</script>
	<%	}else{%>
			<script>
				alert('글쓰기 실패');
				history.back();
			</script>
	<%	}%>
</body>
</html>