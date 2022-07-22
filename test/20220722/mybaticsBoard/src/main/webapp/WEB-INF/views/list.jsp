<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>boardList</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){
			
		});
		function trclick(bid){
			location.href ='${conPath}/content.do?bid='+bid+'&pageNum=${paging.currentPage}';
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<!-- 글 쓰기 성공/실패 alert -->
	<c:if test="${writeResult eq SUCCESS}">
		<script> alert('글 작성 성공');</script>
	</c:if>
	<c:if test="${writeResult eq FAIL}">
		<script> alert('글 작성 실패');</script>
	</c:if>
	<!-- 글 삭제 성공/실패 alert -->
	<c:if test="${deleteResult eq SUCCESS}">
		<script> alert('${param.bid}번 글 삭제 성공');</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL}">
		<script> alert('${param.bid}번 글 삭제 실패');</script>
	</c:if>
	<!-- 답변글 작성 성공/실패 alert -->
	<c:if test="${replyResult eq SUCCESS}">
		<script> alert('답변글 작성 성공');</script>
	</c:if>
	<c:if test="${replyResult eq FAIL}">
		<script> alert('답변글 작성 실패');</script>
	</c:if>
	<table>
		<tr onclick="location.href='${conPath}/write.do?pageNum=${paging.currentPage }'">
			<th>글쓰기</th>
		</tr>
	</table>
	<table>
		<caption>게시판</caption>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>IP</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${paging.totCnt eq 0 }">
			<tr>
				<th colspan="6">등록된 글이 없습니다</th>
			</tr>
		</c:if>
		<c:forEach var="list" items="${boardList }">
			<tr class="list" onclick="trclick(${list.bid})">
				<td>${list.bid }</td>
				<td>${list.bname }</td>
				<td class="left">
					<c:forEach var="i" begin="1" end="${list.bindent }">
						<c:if test="${i == list.bindent }">
						 ┗
						</c:if>
						<c:if test="${i != list.bindent }">
						  &nbsp; &nbsp; &nbsp;
						</c:if>
					</c:forEach>
					${list.btitle }
				</td>
				<td>${list.bip }</td>
				<td><fmt:formatDate value="${list.bdate }" pattern="yy년MM월dd일(E)"/></td>
				<td>${list.bhit }</td>
			</tr>
		</c:forEach>
	</table>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/list.do?pageNum=${paging.startPage - 1 }">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[ <a href="${conPath }/list.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[ <a href="${conPath }/list.do?pageNum=${paging.endPage + 1 }">다음</a> ]
		</c:if>
	</div>
</body>
</html>