<%@page import="com.lec.friend.FriendDaoConn"%>
<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<% String result = request.getParameter("result"); %>
	<script>
		window.onload = function() {
			if(<%=result%>=="1") {
				alert('친구추가 성공');
			} else if(<%=result%>=="0") {
				alert('친구추가 실패');			
			}
		}
		function searchFriend() {
			var name = frm.name.value;
			var phone = frm.phone.value;
			location.href="friendInputList.jsp?name="+name+"&phone="+phone;
		}
	</script>
</head>
<body>
	<form name="frm" action="friendInputListPro.jsp">
		친구이름 <input type="text" name="name" required="required" size="4">
		전화  <input type="tel" name="phone" required="required" size="8" pattern="\d{2,3}[ .-]{0,1}\d{3,4}[ .-]{0,1}[0-9]{4}">
		<input type="button" value="검색" onclick="searchFriend()">
		<input type="submit" value="추가" size="7">
	</form>
	<table>
		<tr>
			<td>순번</td>
			<td>이름</td>
			<td>전화</td>
		</tr>		
		<%
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			if(name==null) name = "";
			if(phone==null) phone = "";			
			FriendDaoConn dao = FriendDaoConn.getInstance();
			ArrayList<FriendDto> friends = dao.outputFriend(name, phone);
			for(FriendDto d : friends){
				out.println("<tr>");
				out.println("<td>"+d.getFnum()+"</td>");
				out.println("<td>"+d.getName()+"</td>");
				out.println("<td>"+d.getPhone()+"</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>