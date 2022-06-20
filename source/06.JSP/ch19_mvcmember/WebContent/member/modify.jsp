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
	<c:if test="${not empty modifyResult }">
		<script>
			alert('${modifyResult}');
			history.back();
		</script>
	</c:if>
	<form action="modify.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value="${member.mid }" readonly="readonly"></td>
				<td rowspan="3">
					<img alt="사진" src="${conPath }/fileUpFolder/${member.mphoto }" width="100"><br>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpw" required="required" value="${member.mpw }"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" required="required" value="${member.mname }"></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="memail" value="${member.memail }"></td>
				<td><input type="file" name="mphoto"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td colspan="2"><input type="date" name="mbirth" value="${member.mbirth }"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2"><input type="text" name="maddress" value="${member.maddress }"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="정보수정">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>