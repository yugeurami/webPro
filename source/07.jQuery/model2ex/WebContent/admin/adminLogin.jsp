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
	<link href="${conPath}/css/login.css" rel="stylesheet" type="text/css">
	<style></style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="login">
		<form action="${conPath }/adminLogin.do" method="post">
			<table>
				<tr>
					<th><label for="aid">ID</label></th>
					<td>
						<input type="text" name="aid" id="aid" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="apw">PW</label></th>
					<td><input type="password" name="apw" id="apw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="관리자 로그인">					
					</td>					
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>