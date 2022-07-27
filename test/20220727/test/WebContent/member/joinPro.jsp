<%@page import="com.test.dto.MemberDto"%>
<%@page import="com.test.dao.MemberDao"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Date"%>
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
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.test.dto.MemberDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<% 
		String tempJoindate = request.getParameter("tempJoindate");
		if(!tempJoindate.equals("")){
			dto.setJoindate(Date.valueOf(tempJoindate));
		}
		MemberDao dao = new MemberDao();
		int result = dao.memberJoin(dto.getCustname(), dto.getPhone(), dto.getAddress(), dto.getJoindate(), dto.getGrade(), dto.getCity());
		if(result == MemberDao.SUCCESS){%>			
			<script>
				alert('회원 등록이 완료됐습니다');
				location.href = '../main/main.jsp';
			</script>
	<%}else{%>		
		<script>
			alert('회원 등록에 실패했습니다.');
			location.href = '../member/join.jsp';
		</script>
	<%}%>
</body>
</html>