<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
		#content {width: 800px; height:350px; margin: 50px auto; }
		img{width: 100px;}
		a {text-decoration: none; color:black;}
		b {color:red;}
		#paging{
			padding : 10px;
		}
		#search{
			width : 100%;
			text-align : center;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="book.do" id="search">
			<input type="hidden" name="method" value="list">
			<input type="hidden" name="pageNum" value="1">
			<select name="schItem">
				<option>검색조건</option>
				<option value="all" 
					<c:if test="${param.schItem == 'all' }"> selected="selected"</c:if>>
					책이름+저자
				</option>
				<option value="btitle" 
					<c:if test="${param.schItem == 'btitle' }"> selected="selected"</c:if>>
					책이름
				</option>
				<option value="bwriter"
					<c:if test="${param.schItem == 'bwriter' }"> selected="selected"</c:if>>
					저자
				</option>
			</select>
			<input type="text" name="schWord" value="${param.schWord }">
			<input type="submit" value="검색">
		</form>
		<table>
			<caption>책 리스트</caption>
			<tr>
			<c:if test="${empty bookList }">
				<td>해당 검색 결과가 없습니다</td>
			</c:if>
			<c:forEach var="book" items="${bookList }">
				<td>
				   <span class="title">${book.btitle }</span><br>
				   <a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=${param.pageNum }">
				   <img src="${conPath }/bookImgFileUpload/${book.bimg1}"></a><br>
				   ${book.bwriter } 著 <br>
				   출판일 : ${book.brdate }
				</td>
			</c:forEach>
			</tr>
		</table>
	<div>
	<div id="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/book.do?method=list&pageNum=${paging.startPage - 1 }&schItem=${param.schItem }&schWord=${param.schWord}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[ <a href="${conPath }/book.do?method=list&pageNum=${i }&schItem=${param.schItem }&schWord=${param.schWord}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[ <a href="${conPath }/book.do?method=list&pageNum=${paging.endPage + 1 }&schItem=${param.schItem }&schWord=${param.schWord}">다음</a> ]
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
