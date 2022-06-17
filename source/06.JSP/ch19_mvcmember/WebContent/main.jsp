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
<body>
	<c:if test="${member != null }">
		<table>
			<tr>
				<td>${member.mname }(${member.mid })님 어서오세요</td>
			</tr>
			<tr>
				<td>
					
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>