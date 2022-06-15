<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<body>
	<c:set var="num" value="1234567.8"/>
	<p>num : ${num }</p>
	<p>세자리마다 , : <fmt:formatNumber value="${num }" groupingUsed="true"/></p>
	<p>세자리마다 , : <fmt:formatNumber value="${num }" pattern="#,###.#"/></p>
	<p>소수점 2자리(소수점 한자리의 경우 뒤에 0) : <fmt:formatNumber value="${num }" pattern="#,###.00"/></p>
	<p>소수점 2자리(소수점 한자리의 경우 한자리만 출력) : <fmt:formatNumber value="${num }" pattern="#,###.##"/></p>
	<c:set var="num" value="123456.789"/>
	<p>소수점 2자리(소수점 두자리 이상의 경우 반올림) : <fmt:formatNumber value="${num }" pattern="#,###.00"/></p>
	<p>소수점 2자리(소수점 두자리 이상의 경우 반올림) : <fmt:formatNumber value="${num }" pattern="#,###.##"/></p>
</body>
</html>