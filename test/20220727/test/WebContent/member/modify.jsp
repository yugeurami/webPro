<%@page import="com.test.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&family=Noto+Sans+KR:wght@300&display=swap');
	</style>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
	<script>
		function infoConfirm(){
			if(!frmJoin.custname.value){
				alert('회원성명은 필수 입력사항입니다');
				frmJoin.custname.focus();
				return false;
			}
			if(!frmJoin.grade.value){
				alert('등급을 입력해주세요');
				frmJoin.grade.focus();
				return false;
			}
			if(frmJoin.grade.value &&
				frmJoin.grade.value.toUpperCase()!='A' &&
				frmJoin.grade.value.toUpperCase()!='B' &&
				frmJoin.grade.value.toUpperCase()!='C'){
					alert('유효하지 않은 등급입니다');
					frmJoin.grade.value = '';
					frmJoin.grade.focus();
					return false;
				}
		}
	</script>
</head>
<body>
	<jsp:useBean id="dto" class="com.test.dto.MemberDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		int custno = Integer.parseInt(request.getParameter("custno"));
		MemberDao dao = new MemberDao();
		dto = dao.getMember(custno);
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<form action="modifyPro.jsp" method="post" name="frmJoin" onsubmit="return infoConfirm()">
			<div id="join_title">홈쇼핑 회원 정보 수정</div>
			<table>
				<tr>
					<th>회원번호</th>
					<td>
						<input type="text" name="custno" class="custno" id="custno" value="<%=custno %>" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th><label for="custname">회원성명</label></th>
					<td>
						<input type="text" name="custname" class="custname" value="<%=dto.getCustname() %>" id="custname">
					</td>
				</tr>
				<tr>
					<th><label for="phone">회원 전화</label></th>
					<td>
						<input type="tel" name="phone" id="phone" value="<%=dto.getPhone() != null ? dto.getPhone() : "" %>" class="phone">
					</td>
				</tr>
				<tr>
					<th><label for="address">회원 주소</label></th>
					<td>
						<input type="text" name="address" class="address" value="<%=dto.getAddress()  != null ? dto.getAddress() : "" %>" id="address">
					</td>
				</tr>
				<tr>
					<th><label for="tempJoindate">가입일자</label></th>
					<td>
						<input type="date" name="tempJoindate" class="tempJoindate" id="tempJoindate" value="<%= dto.getJoindate() != null ? dto.getJoindate() : ""  %>">
					</td>
				</tr>
				<tr>
					<th><label for="grade">고객 등급<br>(A:Vip, B:일반, C:직원)</label></th>
					<td>
						<input type="text" name="grade" class="grade" id="grade" value="<%= dto.getGrade() != null ? dto.getGrade() : "" %>" >
					</td>
				</tr>
				<tr>
					<th><label for="city">도시코드</label></th>
					<td>
						<input type="text" name="city" class="city" id="city" value="<%= dto.getCity() != null ? dto.getCity() : "" %>" >
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정" class="joinBtn_style">
						<input type="button" value="조회" class="joinBtn_style" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>