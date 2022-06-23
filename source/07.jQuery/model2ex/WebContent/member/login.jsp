<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&display=swap');
	</style>
	<link href="${conPath}/css/login.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#mid').val("${mid }");
			$('#join').click(function(){
				location.href="${conPath}/joinView.do";
			});
		});
	</script>
	<c:if test="${not empty joinResult }">
		<script>alert('${joinResult }');</script>
	</c:if>
	<c:if test="${not empty joinErrorMSG }">
		<script>
			alert('${joinErrorMSG }');
			history.back();
		</script>
	</c:if>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="login">
		<form action="${conPath }/login.do" method="post">
			<table>
				<tr>
					<th><label for="mid">ID</label></th>
					<td>
						<input type="text" name="mid" id="mid" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="mpw">PW</label></th>
					<td><input type="password" name="mpw" id="mpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">					
						<input type="button" id="join" value="회원가입">					
					</td>					
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>