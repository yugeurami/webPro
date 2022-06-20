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
	<c:if test="${not empty loginResult }">
		<script>
			alert('${loginResult }');
			history.back();
		</script>
	</c:if>
	<c:if test="${member != null }">
		<table>
			<tr>
				<td>${member.mname }(${member.mid })님 어서오세요</td>
			</tr>
			<tr>
				<td><hr></td>
			</tr>
			<tr>
				<td>
					<button onclick="location='${conPath }/modifyView.do'">정보수정</button>
					<button onclick="location='${conPath }/logout.do'">로그아웃</button>
					<button onclick="location='${conPath }/allView.do'">전체회원보기</button>
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${member == null }">
		<table>
			<tr>
				<td>로그인 상태가 아닙니다</td>
			</tr>
			<tr>
				<td><hr></td>
			</tr>
			<tr>
				<td>
					<button onclick="location='${conPath }/loginView.do'">로그인</button>
					<button onclick="location='${conPath }/joinView.do'">회원가입</button>
					<button onclick="location='${conPath }/allView.do'">전체회원보기</button>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>