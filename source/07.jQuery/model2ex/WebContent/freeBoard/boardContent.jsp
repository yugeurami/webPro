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
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<style></style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<table>
	<caption><h2>${content.fid }번 글 상세보기</h2></caption>
		<tr>
			<th>글 제목</th>
			<td>${content.ftitle }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${content.mname }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${content.fcontent }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>${content.ffilename }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${content.frdate }" pattern="yy/MM/dd(E)"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${content.fhit }</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${content.fip }</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${not empty member}">
					<c:if test="${member.mid eq content.mid}">
						<button class="btn" onclick="location='${conPath}/boardModifyView.do?fid=${content.fid }&pageNum=${param.pageNum }'">수정</button>
						<button class="btn" onclick="location='${conPath}/boardDelete.do?fid=${content.fid }&pageNum=${param.pageNum }'">삭제</button>
					</c:if>
					<button class="btn" onclick="location='${conPath}/BoardreplyView.do?fid=${content.fid }&pageNum=${param.pageNum }'">답변</button>
				</c:if>
				<c:if test="${not empty admin }">
					<button class="btn" onclick="location='${conPath}/boardDelete.do?fid=${content.fid }&pageNum=${param.pageNum }'">삭제</button>
				</c:if>
				<button class="btn" onclick="location='${conPath }/boardList.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>