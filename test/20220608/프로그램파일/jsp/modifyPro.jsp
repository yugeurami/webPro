<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String pwChk = request.getParameter("pwChk");
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempbirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null){
			sessionPw = customer.getCpw();
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			if(dto.getCpw()==null){
				dto.setCpw(sessionPw);
			}
			CustomerDao dao = new CustomerDao();
			int result = dao.modifyCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("customer", dto);
	%>			<script>
					alert('회원정보 수정이 완료되었습니다');
					location.href = 'main.jsp';
				</script>
	<%
			}else{ 
	%>			<script>
					alert('정보 수정에 실패했습니다 정보가 너무 깁니다');
					history.go(-1);
				</script>
	<%				
			}
		} else{ 
	%>		<script>
				alert('현 비밀번호가 바르지 않습니다');
				history.back();
			</script>
	<%	
		}
	%>
</body>
</html>