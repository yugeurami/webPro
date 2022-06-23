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
	<jsp:include page="../main/header.jsp"/>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert('글 작성 성공');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
			alert('글 작성 실패');
		</script>
	</c:if>
	<c:if test="${modifyResult eq SUCCESS }">
		<script>
			alert('글 수정 성공');
		</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert('글 수정 실패');
		</script>
	</c:if>
	<c:if test="${deleteResult eq SUCCESS }">
		<script>
			alert('글 삭제 성공');
		</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL }">
		<script>
			alert('글 삭제 실패');
		</script>
	</c:if>
	<c:if test="${replyResult eq SUCCESS }">
		<script>
			alert('답변글 작성 성공');
		</script>
	</c:if>
	<c:if test="${deletreplyResulteResult eq FAIL }">
		<script>
			alert('답변글 작성 실패');
		</script>
	</c:if>
	<c:if test="${param.pageNum }">
		String pageNum = "1";
	</c:if>
	<table>
		<caption><h2>자유 게시판</h2></caption>
		<c:if test="${not empty member }">
			<tr><td colspan="5" onclick="location='${conPath }/boardWriteView.do'">글쓰기</td></tr>
		</c:if>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:if test="${list.size() eq 0 }">
			<tr><td colspan="5">등록된 글이 없습니다</td></tr>
		</c:if>
		<c:if test="${list.size() != null }">
			<c:forEach var="content" items="${list }">
				<tr onclick="location.href='${conPath }/boardContent.do?fid=${content.fid}&pageNum=${pageNum }'">
					<td>${content.fid }</td>
					<td class="left">
					<c:forEach var="i" begin="1" end="${content.findent }">
						<c:if test="${i eq content.findent }">
							┗ [답]
						</c:if>
						<c:if test="${i != content.findent }">
							&nbsp; &nbsp;
						</c:if>
					</c:forEach>
					${content.ftitle }
					<c:if test="${content.fhit > 10 }">★</c:if>
					</td>
					<td>${content.mname }</td>
					<td>${content.fhit }</td>
					<td><fmt:formatDate value="${content.frdate }" pattern="yy년 MM월dd일(E)"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			<a href="${conPath }/boardList.do?pageNum=${startPage-1 }">[ 이전 ]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				<a href="${conPath }/boardList.do?pageNum=${i}">[ ${i } ]</a>
			</c:if>
		</c:forEach>
		<c:if test="${ endPage < pageCnt }">
			<a href="${conPath }/boardList.do?pageNum=${endPage + 1 }">[ 다음 ]</a>
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>