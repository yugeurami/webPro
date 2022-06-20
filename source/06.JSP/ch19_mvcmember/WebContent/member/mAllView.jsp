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
		<caption>전체 회원 보기</caption>
		<tr>
			<c:if test="${list eq null }">
				<td colspan="3">등록된 회원이 없습니다</td>
			</c:if>
			<c:forEach var="i" items="${list }">
				<td>
					<p><img src="${conPath }/fileUpFolder/${i.mphoto }" width="100"></p>
					<p>${i.mname }</p>
					<p>(${i.mid })</p>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td><input type="button" value="메인화면" onclick="location='${conPath }/member/main.jsp'"></td>
		</tr>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			<a href="${conPath }/allView.do?pageNum=1"> &lt;&lt; </a>
			&emsp;
			<a href="${conPath }/allView.do?pageNum=${startPage-1 }"> &lt; </a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				<a href="${conPath }/allView.do?pageNum=${i}">[ ${i } ]</a>
			</c:if>
		</c:forEach>
		<c:if test="${ endPage < pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage + 1 }"> &gt; </a>
			&emsp;
			<a href="${conPath }/allView.do?pageNum=${pageCnt }"> &gt;&gt; </a>
		</c:if>
	</div>
</body>
</html>