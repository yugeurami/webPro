<%@page import="com.lec.member.MemberDaoConnPool"%>
<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String	pw = request.getParameter("pw");
		MemberDaoConnPool mDao = new MemberDaoConnPool(); // 싱글톤 아님
		int result = mDao.loginCheck(id, pw);
		if(result == MemberDaoConnPool.LOGIN_SUCCESS){ // 로그인 성공
			MemberDto member = mDao.getMember(id);
			session.setAttribute("member", member);
			response.sendRedirect("main.jsp");
		}else if(result == MemberDaoConnPool.LOGIN_FAIL_PW){ // 비밀번호 오류
	%>		<script>
				alert('비밀번호를 확인하세요');
				history.back();
			</script>
	<%						
		}else{ // 아이디 오류
	%>		<script>
				alert('아이디를 확인하세요');
				history.go(-1);
			</script>
	<%									
		}
	%>
</body>
</html>