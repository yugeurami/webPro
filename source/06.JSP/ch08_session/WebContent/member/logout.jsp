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
	<%
		String name = (String)session.getAttribute("name");		
		if(session.getAttribute("name")!=null){
			session.invalidate(); // 세션 모두 삭제
		}
	%>
	<script>
			setTimeout(function () {
				location.href="main.jsp";
				}, 5000);
	</script>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		<p>
			로그아웃이 성공적으로 이루어졌습니다
		</p>
		<p>
			5초 뒤 main화면으로 이동합니다
		</p>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>