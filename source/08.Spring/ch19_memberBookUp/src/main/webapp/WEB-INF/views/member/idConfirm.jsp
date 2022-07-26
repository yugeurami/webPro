<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<c:if test="${empty param.mid }">
		<span style="color:red;">ID를 입력하신 후에 중복 확인을 해주세요</span>
	</c:if>	
	<c:if test="${not empty param.mid }">
		<c:if test="${not empty result }">
			<span style="color:red;">중복된 ID입니다</span>
		</c:if>
		<c:if test="${empty result }">
			<span style="color:blue;">사용가능한 ID입니다</span>
		</c:if>
	</c:if>
</body>
</html>