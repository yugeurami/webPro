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
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao dao = BoardDao.getInstance();
		int result = dao.updateBoard(dto);
		if(result == BoardDao.SUCCESS){%>
		<script>
			alert('글 수정 완료');
			location.href = 'list.jsp';
			<%-- location.href= 'content.jsp?num=<%=dto.getNum()%>'; 상세보기 페이지로 --%>
		</script>
<%	}else{%>
		<script>
			alert('글 수정 실패');
			history.back();
		</script>
<%	}%>
	%>
</body>
</html>