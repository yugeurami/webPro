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
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${joinResult eq SUCCESS }">
		<script>
			alert('회원가입 성공');
		</script>
	</c:if>
	<c:if test="${joinResult eq FAIL }">
		<script>
			alert('회원가입 실패');
		</script>
	</c:if>
	<table>
		<tr>
			<th>NUM</th>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>BIRTH</th>
			<th>RDATE</th>
		</tr>
		<c:if test="${memberList.size() eq 0 }">
			<tr><td colspan="6">가입한 회원이 없습니다</td></tr>
		</c:if>
		<c:if test="${memberList.size() != 0 }">
			<c:set var="i" value="1"/>
			<c:forEach var="member" items="${memberList }">
				<tr>
					<td>${i }</td>
					<td>${member.id }</td>
					<td>${member.pw }</td>
					<td>${member.name }</td>
					<td><fmt:formatDate value="${member.birth }" pattern="MM월 dd일"/></td>
					<td>${member.rdate }</td>
				</tr>
				<c:set var="i" value="${i+1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<button onclick="location='${conPath}/member/join.jsp'">회원가입</button>
	</div>
</body>
</html>