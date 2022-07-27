<%@page import="com.test.dao.MemberDao"%>
<%@page import="com.test.dto.MoneyDto"%>
<%@page import="com.test.dao.MoneyDao"%>
<%@page import="com.test.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
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
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberDto> members = memberDao.memberPriceList();
		MoneyDao dao = new MoneyDao();
		ArrayList<MoneyDto> moneys = dao.moneyList();
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="mainForm_wrap">
		<table>
			<caption>회원 매출 조회</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
		<%
			for(int i = 0 ; i<members.size() ; i++){
				
				String grade = members.get(i).getGrade(); 
				if(grade.equals("A")){
					grade = "VIP";
				}else if(grade.equals("B")){
					grade = "일반";
				}else if(grade.equals("C")){
					grade = "직원";
				}
		%>
			<tr>
				<td><%=members.get(i).getCustno()%></td>
				<td><%=members.get(i).getCustname() %></td>
				<td><%=grade %></td>
				<td><%=members.get(i).getAllprice() %></td>
			</tr>
		<%
			}
		%>
		</table>
		<table>
			<caption>제품 매출 조회</caption>
			<tr>
				<th>제품코드</th>
				<th>매출</th>
			</tr>
		<%
			for(int i = 0 ; i<moneys.size() ; i++){
		%>
			<tr>
				<td><%=moneys.get(i).getPcode()%></td>
				<td><%=moneys.get(i).getAllprice() %></td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>