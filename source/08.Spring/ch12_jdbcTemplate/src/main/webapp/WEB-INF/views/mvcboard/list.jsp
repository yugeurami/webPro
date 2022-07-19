<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LIST</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){
			$('tr').click(function(){
				var bid =Number($(this).children().eq(2).text());
				if(!isNaN(bid)){
					location.href= '${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum }';
				}
			});
		});
		function trclicked(bid){
			location.href= '${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum }';
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<!-- 글 쓰기 성공/실패 alert -->
	<c:if test="${WriteResult eq SUCCESS}">
		<script> alert('글 작성 성공');</script>
	</c:if>
	<c:if test="${WriteResult eq FAIL}">
		<script> alert('글 작성 실패');</script>
	</c:if>
	<!-- 글 삭제 성공/실패 alert -->
	<c:if test="${deleteResult eq SUCCESS}">
		<script> alert('글 삭제 성공');</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL}">
		<script> alert('글 삭제 실패');</script>
	</c:if>
	<!-- 답변글 작성 성공/실패 alert -->
	<c:if test="${replyResult eq SUCCESS}">
		<script> alert('답변글 작성 성공');</script>
	</c:if>
	<c:if test="${replyResult eq FAIL}">
		<script> alert('답변글 작성 실패');</script>
	</c:if>
	<c:set var="oNum" value="${orderNum }"/>
	<c:set var="iNum" value="${inverseNum }"/>
	<table>
		<caption>BOARD LIST</caption>
		<tr>
			<th>순차번호</th>
			<th>역순번호</th>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr>
				<th colspan="7">등록된 글이 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach var="bDto" items="${boardList }">
				<tr class="content" onclick="trclicked(${bDto.bid})">
					<td>${oNum }</td>
					<td>${iNum }</td>
					<td>${bDto.bid }</td>
					<td>${bDto.bname }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${bDto.bindent }">
							<c:if test="${i == bDto.bindent }">
							 ┗
							</c:if>
							<c:if test="${i != bDto.bindent }">
							  &nbsp; &nbsp; &nbsp;
							</c:if>
						</c:forEach>
						${bDto.btitle }
					</td>
					<td>
						<fmt:formatDate value="${bDto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a) "/>
					</td>
					<td>
						<fmt:formatNumber value="${bDto.bhit }" groupingUsed="true"/> 
					</td>
				</tr>
				<c:set var="oNum" value="${oNum + 1 }"/>
				<c:set var="iNum" value="${iNum - 1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<div class="write" onclick="location.href='${conPath }/mvcboard/writeView.do'">
		<a>글쓰기</a>
	</div>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }"> 
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${startPage - 1}"> 이전 </a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b> ${i } </b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/mvcboard/list.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }"> 
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${endPage + 1}"> 다음 </a> ]
		</c:if>
	</div>
</body>
</html>