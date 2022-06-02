<%@page import="com.lec.member.MemberDaoConnPool"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));	
		}
		MemberDto member = (MemberDto)session.getAttribute("member");
		String sessionPw = null;
		if(member!=null){
			sessionPw = member.getPw(); // 세션의 pw를 sessionPw에 할당
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){ // 현재 비밀번호를 맞게 입력한 경우 정보 수정 진행
			// 새 비밀번호가 null이면
			if(dto.getPw()==null){
				dto.setPw(sessionPw);
			}
			MemberDaoConnPool mDao = new MemberDaoConnPool();
			int result = mDao.modifyMember(dto);
			if(result == MemberDaoConnPool.SUCCESS){ // 수정성공
				session.setAttribute("member", dto);
	%>			<script>
					alert('회원정보 수정이 완료되었습니다');
					location.href = 'main.jsp';
				</script>
	<%
			}else{ // 수정 실패
	%>			<script>
					alert('정보 수정에 실패했습니다 정보가 너무 깁니다');
					history.go(-1);
				</script>
	<%				
			}
		} else{ // 현 비밀번호가 틀릴 경우 수정 안함
	%>		<script>
				alert('현 비밀번호가 바르지 않습니다');
				history.back();
			</script>
	<%	
		}
	%>
</body>
</html>