<%@page import="com.lec.member.MemberDaoConnPool"%>
<%@page import="java.sql.Timestamp"%>
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
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setBirth(Timestamp.valueOf(tempbirth+" 00:00:00"));
			// 타입을 Date로 했을 때 : dto.setBirth(Date.valueOf(tempbirth))
		}
		MemberDaoConnPool mDao = new MemberDaoConnPool();
		int result = mDao.confirmId(dto.getId()); // ID 중복체크
		if(result == MemberDaoConnPool.MEMBER_NONEXISTENT){ // 사용가능한 ID
			result = mDao.joinMember(dto); // 회원가입
			if(result == MemberDaoConnPool.SUCCESS){ // 회원가입 성공
				session.setAttribute("id", dto.getId());
	%>			<script>
					alert('회원가입 감사합니다. 로그인 후 서비스를 이용하세요');
					location.href = 'login.jsp';
				</script>
	<%					
			}else{ // 회원가입 실패
	%>			<script>
					alert('회원가입에 실패했습니다 회원정보를 다시 입력해주세요');
					location.href = 'join.jsp';
				</script>
	<%			
			}
		}else{ //중복된 ID
	%>	<script>
			alert('중복된 ID입니다. 다른 ID를 사용하세요');
			history.back();
		</script>
	<%			
		}
	%>
</body>
</html>