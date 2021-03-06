<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
	<script src="${conPath }/js/join.js"></script>
<body>
	<form action="${conPath }/memberJoin.do" method="post" name="join_frm">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>PW CHECK</th>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>BIRTH</th>
				<td><input type="date" name="birth"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="infoConfirm()" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="회원목록" onclick="location='${conPath}/memberList.do'" class="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>