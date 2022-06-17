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
	<table>
	<caption>${content.bid }번 글 상세보기</caption>
		<tr>
			<th>글 제목</th>
			<td>${content.btitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${content.bname }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${content.bcontent }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${content.bdate }" pattern="yy/MM/dd(E)"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${content.bhit }</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${content.bip }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn" onclick="location='${conPath}/modify_view.do?bid=${content.bid }&pageNum=${param.pageNum }'">수정</button>
				<button class="btn" onclick="location='${conPath}/delete.do?bid=${content.bid }&pageNum=${param.pageNum }'">삭제</button>
				<button class="btn" onclick="location='${conPath}/reply_view.do?bid=${content.bid }&pageNum=${param.pageNum }'">답변</button>
				<button class="btn" onclick="location='${conPath }/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>