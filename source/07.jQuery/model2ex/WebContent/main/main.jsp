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
	<style>
		#main{
			width : 600px;
			height : 600px;
			margin : 0 auto;
			text-align : center;
			line-height : 600px;
		}
	</style>
	<c:if test="${not empty withdrawalResult }">
		<script>alert('${withdrawalResult }');</script>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#withdrawal").click(function(){
				var withdrawal = confirm('정말로 탈퇴하시겠습니까? 회원 탈퇴 시 복구가 불가능합니다');
				if(withdrawal){
					location.href="${conPath }/withdrawal.do";
				}
			});
		});
	</script>
	<c:if test="${not empty loginResult }">
		<script>alert('${loginResult }');</script>
	</c:if>
	<c:if test="${not empty loginError }">
		<script>
			alert('${loginError }');
			location.href="loginView.do";
		</script>
	</c:if>
	<c:if test="${not empty modifyResult }">
		<script>alert('${modifyResult }');</script>
	</c:if>
	<c:if test="${not empty modifyErrorMSG }">
		<script>
			alert('${modifyErrorMSG }');
			location.href="modifyView.do";
		</script>
	</c:if>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="main">
	<h1>메인 페이지 입니다</h1>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>