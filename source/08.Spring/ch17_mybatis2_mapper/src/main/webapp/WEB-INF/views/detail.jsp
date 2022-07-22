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
	<table>
		<caption>직원정보</caption>
		<tr>
			<th>사번</th>
			<td>${detail.empno }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${detail.ename }</td>
		</tr>
		<tr>
			<th>업무</th>
			<td>${detail.job }</td>
		</tr>
		<tr>
			<th>상사사번</th>
			<td>${detail.mgr }</td>
		</tr>
		<tr>
			<th>입사일</th>
			<td><fmt:formatDate value="${detail.hiredate }" dateStyle="long"/></td>
		</tr>
		<tr>
			<th>급여</th>
			<td>${detail.sal }</td>
		</tr>
		<tr>
			<th>보너스</th>
			<td>${detail.comm }</td>
		</tr>
		<tr>
			<th>부서코드</th>
			<td>${detail.deptno }</td>
		</tr>
		<tr>
			<td colspan="3">
				<button onclick="location='${conPath}/empDeptList.do?pageNum=${param.pageNum }'">목록</button>
				<button onclick="location='${conPath}/updateView.do?empno=${detail.empno }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location='${conPath}/delete.do?empno=${detail.empno }&pageNum=${param.pageNum }'">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>