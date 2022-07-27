<%@page import="com.test.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> dtos = dao.memberList();
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="mainForm_wrap">
		<table>
			<caption>회원 목록 조회/수정</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>회원전화</th>
				<th>주소</th>
				<th>가입일</th>
				<th>고객등급</th>
				<th>도시코드</th>
			</tr>
		<%
			for(int i = 0 ; i<dtos.size() ; i++){
		%>
			<tr>
				<td>
					<a href="modify.jsp?custno=<%=dtos.get(i).getCustno()%>"><%=dtos.get(i).getCustno()%></a>
				</td>
				<td><%=dtos.get(i).getCustname() %></td>
				<td><%=dtos.get(i).getPhone() != null ? dtos.get(i).getPhone() : "-"%></td>
				<td><%=dtos.get(i).getAddress() != null ? dtos.get(i).getAddress() : "-" %></td>
				<td><%=dtos.get(i).getJoindate() != null ? dtos.get(i).getJoindate() : "-" %></td>
				<td><%=dtos.get(i).getGrade() != null ? dtos.get(i).getGrade() : "-" %></td>
				<td><%=dtos.get(i).getCity() != null ? dtos.get(i).getCity() : "-"%></td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>