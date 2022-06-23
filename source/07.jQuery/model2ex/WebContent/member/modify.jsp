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
	<c:if test="${empty member }">
		<script>
			location.href="${conPath}/main.do";
		</script>
	</c:if>
	<script>
		$(document).ready(function(){
			$('#oldpw').keyup(function(){
				var oldpw = $('#oldpw').val();
				if(!oldpw){
					$('#pwResult').text('비밀번호를 입력해주세요');				
				}else if(oldpw == ${member.mpw }){
					$('#pwResult').text('비밀번호가 맞습니다');				
				}else{
					$('#pwResult').text('비밀번호가 다릅니다');				
				}
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
				var patternMail = /^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+){1,2}$/;
				var memail = $('#memail').val();
				if(patternMail.test(memail)){
					$.ajax({
						url : '${conPath}/emailCheck.do',
						data : 'memail='+memail,
						type : 'get',
						dataType : 'html',
						success : function(data){
							$('#emailCheckResult').html(data);							
						}
					});					
				}else if(!memail){
					$('#emailCheckResult').html('&nbsp;');
				}else {
					$('#emailCheckResult').html('이메일 형식을 지켜주세요');
				}
			});
			$('form').submit(function(){
				var pwResult = $('#pwResult').text().trim();
				var pwCheckResult = $('#pwCheckResult').text().trim();
				var emailCheckResult = $('#emailCheckResult').text().trim();
				if(pwResult == '비밀번호가 다릅니다' || pwCheckResult == '비밀번호 불일치'){
					alert('비밀번호가 일치하지 않습니다');
					return false;
				}else if(emailCheckResult == '중복된 이메일입니다'){
					alert('사용가능한 이메일을 입력해주세요');
					return false;
				}
			});
			$('input[type=button]').click(function(){
				location.href="${conPath}/main.do"
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
		<form action="modify.do" method="post" name="frmJoin" enctype="multipart/form-data" >
			<table>
				<caption><h3>회원 정보 수정</h3></caption>
				<tr>
					<th><label for="mid">아이디</label></th>
					<td>
						<input type="text" name="mid" class="mid" id="mid" autofocus="autofocus" readonly="readonly" value="${member.mid }">
					</td>
					<td rowspan="3">
						<img src="${conPath }/memberPhoto/${member.mphoto }" height="200">
					</td>
				</tr>
				<tr>
					<th><label for="oldpw">비밀번호</label></th>
					<td>
						<input type="password" name="oldpw" class="oldpw" id="oldpw" required="required">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="pwResult"> 비밀번호를 입력해주세요 </div>
					</td>
				</tr>
				<tr>
					<th><label for="mpw">수정할 비밀번호</label></th>
					<td colspan="2">
						<input type="password" name="mpw" class="mpw" id="mpw" placeholder="수정 시에만 입력해주세요">
					</td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호 확인</label></th>
					<td colspan="2">
						<input type="password" name="pwChk" id="pwChk" class="pwChk">
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2">
						<div id="pwCheckResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="mname">이름</label></th>
					<td colspan="2">
						<input type="text" name="mname" class="mname" id="mname" required="required" value="${member.mname }">
					</td>
				</tr>
				<tr>
					<th><label for="memail">이메일</label></th>
					<td colspan="2">
						<input type="text" name="memail" id="memail" class="memail" value="${member.memail }">
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2">
						<div id="emailCheckResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<th colspan="2">
						<input type="file" name="mphoto" id="mphoto" class="mphoto">
					</th>
				</tr>
				<tr>
					<th><label for="tempbirth">생년월일</label></th>
					<td colspan="2">
						<input type="text" name="tempbirth" class="tempbirth" id="datepicker" value="${member.mbirth }">
					</td>
				</tr>
				<tr>
					<th><label for="maddress">주소</label></th>
					<td colspan="2">
						<input type="text" name="maddress" class="maddress" id="maddress" value="${member.maddress }">
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="회원 정보 수정" class="joinBtn_style">
						<input type="button" value="취소" class="joinBtn_style">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>	
</body>
</html>