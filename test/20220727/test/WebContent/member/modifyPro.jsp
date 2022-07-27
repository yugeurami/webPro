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
		int result = dao.memberModify(dto.getCustno(), dto.getCustname(), dto.getPhone(), dto.getAddress(), dto.getJoindate(), dto.getGrade(), dto.getCity());
		if(result == MemberDao.SUCCESS){%>			
			<script>
				alert('회원 정보 수정 성공');
				location.href = '../main/main.jsp';
			</script>
	<%}else{%>		
		<script>
			alert('회원 정보 수정 실패');
			location.href = '../member/modify.jsp?custno=<%=request.getParameter("custno")%>';
		</script>
	<%}%>
</body>
</html>