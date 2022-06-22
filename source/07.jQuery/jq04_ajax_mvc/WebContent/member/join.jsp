<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		tr{
			text-align : center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('input[name="mid"]').keyup(function(){
				var mid = $('input[name="mid"]').val();
				$.ajax({
					url : '${conPath}/idCheck.do',
					data : 'mid='+mid,
					type : 'get',
					dataType : 'html',
					success : function(data){
						$('#idCheckResult').html(data);							
					}
				});
			});
			$('input[name="mpw"], input[name="mpwChk"]').keyup(function(){
				var mpw = $('input[name="mpw"]').val();
				var mpwChk = $('input[name="mpwChk"]').val();
				if(mpw == mpwChk){
					$('#pwCheckResult').text('비밀번호 일치');				
				} else{
					$('#pwCheckResult').text('비밀번호 불일치');				
				}
			});
			$('form').submit(function(){
				var idCheckResult = $('#idCheckResult').text().trim();
				var pwCheckResult = $('#pwCheckResult').text().trim();
				if(idCheckResult == '중복된 ID입니다'){
					alert('사용가능한 ID로 가입하세요');
					return false;
				}else if(pwCheckResult == '비밀번호 불일치'){
					alert('비밀번호가 일치하지 않습니다');
					return false;
				}
			});
		});
	</script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script>
 		 $( function() {
    		$( "#datepicker" ).datepicker({
    			dateFormat : 'yy-mm-dd',
    			changeMonth : true, // 월을 바꿀 수 있는 셀렉트 박스 표시
    			monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    			showMonthAfterYear : true,
   		 		yearSuffix : '년', // "2020년 3월"
   		 		showOtherMonths : true,
    			dayNamesMin:['일','월','화','수','목','금','토'],
				changeYear : true, // 년을 바꿀 수 있는 셀렉트 박스 표시
				minDate : '-100y', // 현재 날짜로부터 100년 이전까지 표시
				yearRange : 'c-100:c+100', // 년도 선택 셀렉트 
    		});
  		});
  </script>
</head>
<body>
	<form action="">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="mid" required="required">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="idCheckResult"> &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td>
					<input type="password" name="mpw" required="required">
				</td>
			</tr>
			<tr>
				<th>PW CHECK</th>
				<td>
					<input type="password" name="mpwChk" required="required">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="pwCheckResult"> &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>BIRTH</th>
				<td>
					<input type="text" name="mbirth" id="datepicker">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="JOIN">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>