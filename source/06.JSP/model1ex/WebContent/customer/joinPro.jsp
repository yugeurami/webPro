<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<% 
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempbirth));
		}
		CustomerDao dao = new CustomerDao();
		int result = dao.confirmId(dto.getCid());
		if(result == CustomerDao.NONEXISTENT){
			result = dao.JoinCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("cid", dto.getCid());
				%>			<script>
								alert('회원가입 감사합니다. 로그인 후 서비스를 이용하세요');
								location.href = 'login.jsp';
							</script>
				<%					
						}else{
				%>			<script>
								alert('회원가입에 실패했습니다 회원정보를 다시 입력해주세요');
								location.href = 'join.jsp';
							</script>
				<%			
						}
		}else{
	%>	<script>
			alert('중복된 ID입니다. 다른 ID를 사용하세요');
			history.back();
		</script>
	<%			
		}
	%>
</body>
</html>