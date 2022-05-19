<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table{
			width : 300px;
			margin : 0 auto;
		}
	</style>
</head>
<body>
	<form action="ex7_result.jsp" method="post">
		<table>
			<caption>회원정보 입력</caption>
				<tr>
					<td><label for="name">이 름</label></td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<td><label for="id">아이디</label></td>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<td><label for="pw">패스워드</label></td>
					<td><input type="password" id="pw" name="pw"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"></td>
				</tr>
		</table>
	</form>	
</body>
</html>