<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
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
		String fpw = request.getParameter("fpw");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao dao = FileboardDao.getInstance();
		int result = dao.delete(fnum, fpw);
		if(result==FileboardDao.SUCCESS){
	%>
		<script>
			alert('글이 삭제되었습니다');
			location.href='fileboardList.jsp?pageNum=<%=pageNum%>';
		</script>
	<%		
		} else{
	%>
		<script>
			alert('비밀번호를 확인해주세요');
			history.back(-1);
		</script>
	<%} %>
</body>
</html>