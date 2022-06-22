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
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&family=Noto+Sans+KR:wght@300&display=swap');
	</style>
	<link href="${conPath}/css/join.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#mid').keyup(function(){
				var mid = $('#mid').val();
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
			$('#mpw, #pwChk').keyup(function(){
				var mpw = $('#mpw').val();
				var mpwChk = $('#pwChk').val();
				if(mpw == mpwChk){
					$('#pwCheckResult').text('비밀번호 일치');				
				} else{
					$('#pwCheckResult').text('비밀번호 불일치');				
				}
			});
			$('#memail').keyup(function(){
				var mid = $('#mid').val();
				var memail = $('#memail').val();
				$.ajax({
					url : '${conPath}/emailChk.do',
					data : 'memail='+memail,
					type : 'get',
					dataType : 'html',
					success : function(data){
						$('#emailCheckResult').html(data);							
					}
				});
			});
			$('form').submit(function(){
				var idCheckResult = $('#idCheckResult').text().trim();
				var pwCheckResult = $('#pwCheckResult').text().trim();
				var emailCheckResult = $('#emailCheckResult').text().trim();
				if(idCheckResult == '중복된 ID입니다'){
					alert('사용가능한 ID로 가입하세요');
					return false;
				}else if(pwCheckResult == '비밀번호 불일치'){
					alert('비밀번호가 일치하지 않습니다');
					return false;
				}else if(emailCheckResult == '중복된 이메일입니다'){
					alert('사용가능한 이메일을 입력해주세요');
					return false;
				}
			});
			$('input[type=button]').click(function(){
				location.href="${conPath}/loginView.do"
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
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<form action="join.do" method="post" name="frmJoin" enctype="multipart/form-data" >
			<table>
				<caption><h3>회원가입</h3></caption>
				<tr>
					<th><label for="mid">아이디</label></th>
					<td>
						<input type="text" name="mid" class="mid" id="mid" autofocus="autofocus" required="required">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="idCheckResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="mpw">비밀번호</label></th>
					<td>
						<input type="password" name="mpw" class="mpw" id="mpw" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호 확인</label></th>
					<td>
						<input type="password" name="pwChk" id="pwChk" class="pwChk" required="required">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="pwCheckResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="mname">이름</label></th>
					<td>
						<input type="text" name="mname" class="mname" id="mname" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="memail">이메일</label></th>
					<td>
						<input type="email" name="memail" id="memail" class="memail" pattern="\w[a-zA-Z0-0_.]+@[a-zA-z]+(\.[a-z]+){1,2}" title="이메일을 확인해주세요">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="emailCheckResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td>
						<input type="file" name="mphoto" id="mphoto" class="mphoto">
					</td>
				</tr>
				<tr>
					<th><label for="tempbirth">생년월일</label></th>
					<td>
						<input type="text" name="tempbirth" class="tempbirth" id="datepicker">
					</td>
				</tr>
				<tr>
					<th><label for="maddress">주소</label></th>
					<td>
						<input type="text" name="maddress" class="maddress" id="maddress">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>	
</body>
</html>