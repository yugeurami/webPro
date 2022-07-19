<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CONTENT</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<!-- 글 수정 성공/실패 alert -->
	<c:if test="${modifyResult eq SUCCESS}">
		<script> alert('글 수정 성공');</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL}">
		<script>
			alert('글 수정 실패'); 
			history.back();
		</script>
	</c:if>
	
	<table>
	<caption>${bDto.bid }번 글 상세보기</caption>
		<tr>
			<th>글 제목</th>
			<td>${bDto.btitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bDto.bname }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bDto.bcontent }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${bDto.bdate }" pattern="yy/MM/dd(E)"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bDto.bhit }</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${bDto.bip }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn" onclick="location='${conPath }/mvcboard/modify.do?bid=${bDto.bid }&pageNum=${param.pageNum }'">수정</button>
				<button class="btn" onclick="location='${conPath }/mvcboard/delete.do?bid=${bDto.bid }&pageNum=${param.pageNum }'">삭제</button>
				<button class="btn" onclick="location='${conPath }/mvcboard/reply.do?bid=${bDto.bid }&pageNum=${param.pageNum }'">답변</button>
				<button class="btn" onclick="location='${conPath }/mvcboard/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>