<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/main.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		content
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>