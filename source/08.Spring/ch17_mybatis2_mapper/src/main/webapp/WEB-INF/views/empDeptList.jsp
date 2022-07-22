<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){

		});
		function trclicked(empno){
			location.href ='${conPath}/detail.do?empno='+empno+'&pageNum=${paging.currentPage}';
		}
	</script>
</head>
<body>
	<c:if test="${updateResult eq 1 }">
		<script> alert('직원 정보 수정 성공'); </script>
	</c:if>
	<c:if test="${deleteResult eq 1 }">
		<script> alert('직원 삭제 성공'); </script>
	</c:if>
	<table>
		<caption>직원 목록</caption>
		<tr>
			<td colspan="6" align="right">
				<a href="${conPath }/writeView.do">직원 등록</a>
			</td>
		</tr>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>업무</th>
			<th>부서명</th>
			<th>입사일</th>
			<th>근무지</th>
		</tr>
		<c:forEach items="${empDeptList }" var="list">
			<tr onclick="trclicked(${list.empno})">
				<td>${list.empno}</td>
				<td>${list.ename }</td>
				<td>${list.job }</td>
				<td>${list.dname }</td>
				<td><fmt:formatDate value="${list.hiredate }" dateStyle="long"/></td>
				<td>${list.loc }</td>
			</tr>
		</c:forEach>
	</table>
	<div id="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/empDeptList.do?pageNum=${paging.startPage - 1 }">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[ <a href="${conPath }/empDeptList.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[ <a href="${conPath }/empDeptList.do?pageNum=${paging.endPage + 1 }">다음</a> ]
		</c:if>
	</div>
</body>
</html>