<%@page import="com.lec.friend.FriendDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%	
		FriendDaoConn friends = FriendDaoConn.getInstance();	
		int result = friends.insertFriend(dto.getName(), dto.getPhone());
		response.sendRedirect("friendInputList.jsp?result="+result);
	%>
	
</body>
</html>