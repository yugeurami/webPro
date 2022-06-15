<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="">
		<input type="number" name="su1"> *
		<input type="number" name="su2"> =
		<input type="number" name="result">
		<input type="submit" value="확인">
	</form>
	<h2>
	${param.su1} * ${param.su2} = ${param.result}
	${not empty param.result ? (param.result == (param.su1 * param.su2) ? "는 정답입니다" : "는 오답입니다") : ""}</h2>
</body>
</html>