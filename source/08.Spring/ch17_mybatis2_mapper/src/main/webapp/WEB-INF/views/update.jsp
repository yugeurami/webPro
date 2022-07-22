<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){

		});
	</script>
</head>
<body>
	<c:if test="${not empty updateResult }">
		<script> alert('${updateResult}'); </script>
	</c:if>
	<form action="update.do" method="post">
		<input type="hidden" name="empno" value="${empDto.empno }">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<table>
			<caption>직원정보</caption>
			<tr>
				<th>사번</th>
				<td>${empDto.empno }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="ename" value="${empDto.ename }" required="required"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="job" value="${empDto.job}" required="required"></td>
			</tr>
			<tr>
				<th>상사사번</th>
				<td><input type="number" name="mgr" value="${empDto.mgr }"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hiredate" value="${empDto.hiredate }"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="sal" value="${empDto.sal }" min="0"></td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><input type="number" name="comm" value="${empDto.comm }" min="0"></td>
			</tr>
			<tr>
				<th>부서코드</th>
				<td><input type="number" name="deptno" value="${empDto.deptno }"></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="수정완료">
					<input type="button" value="목록" onclick="location='empDeptList.do?pageNum=${param.pageNum}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>