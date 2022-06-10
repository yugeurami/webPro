<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<form action="<%=conPath%>/book/bookRegisterPro.jsp" method="post" enctype="multipart/form-data">
		<table>
			<caption>도서 등록</caption>
			<tr>
				<th>도서명</th>
				<td>
					<input type="text" name="btitle" maxlength="33" required="required">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="number" name="bprice" min="0" max="999999" required="required">
				</td>
			</tr>
			<tr>
				<th>대표 이미지</th>
				<td>
					<input type="file" name="bimg1">
				</td>
			</tr>
			<tr>
				<th>세부 이미지</th>
				<td>
					<input type="file" name="bimg2">
				</td>
			</tr>
			<tr>
				<th>소개</th>
				<td>
					<textarea rows="5" cols="20" name="bcontent"></textarea>
				</td>
			</tr>
			<tr>
				<th>할인율</th>
				<td>
					<input type="number" name="bdiscount" min="0" max="100" value="0" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="도서등록" class="btn">
					<input type="reset" value="취소" class="btn">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>