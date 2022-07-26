<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  	<script>
	  $( function() {
	    $( "#datepicker" ).datepicker({
	    	dateFormat : 'yy-mm-dd',
	      	changeMonth: true,
	      	monthNamesShort : ['1월', '2월', '3월', '4월','5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	      	changeYear: true,
	      	yearSuffix : '년', 
	    	showOtherMonths : true, 
	    	dayNamesMin:['일','월','화','수','목','금','토'],
			minDate : '-100y', 
			yearRange : 'c-100:2022' 
	    });
	  });
  	</script>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
		input {
			width : 600px;
		}
		textarea {
			width : 600px;
			height : 150px;
		}
		.btn {
			width : 20%;
		}
		.img{
			text-align : left;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="book.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="method" value="modify">
			<input type="hidden" name="bnum" value="${bookDto.bnum }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<table>
				<tr>
					<th>책제목</th>
					<td><input type="text" name="btitle" value="${bookDto.btitle }" required="required"></td>
				</tr>
				<tr>
					<th>저자</th>
					<td><input type="text" name="bwriter" value="${bookDto.bwriter }" required="required"></td>
				</tr>
				<tr>
					<th>출판일</th>
					<td><input type="text" id="datepicker" name="brdate" value="${bookDto.brdate }" required="required"></td>
				</tr>
				<tr>
					<th>책 이미지 1</th>
					<td>
						<c:if test="${bookDto.bimg1 != 'noImg.png'}">
							<p class="img">현재 이미지 : ${bookDto.bimg1 }</p>
						</c:if>
						<input type="file" name="tempBimg1">
					</td>
				</tr>
				<tr>
					<th>책 이미지 2</th>
					<td>
						<c:if test="${bookDto.bimg2 != 'noImg.png'}">
							<p class="img">현재 이미지 : ${bookDto.bimg2 }</p>
						</c:if>
						<input type="file" name="tempBimg2">
					</td>
				</tr>
				<tr>
					<th>책 소개</th>
					<td><textarea rows="5" cols="10" name="binfo">${bookDto.binfo }</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="이전으로" class="btn" onclick="history.back()">
						<input type="submit" value="등록" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
