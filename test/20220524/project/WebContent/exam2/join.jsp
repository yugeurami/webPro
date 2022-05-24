<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<script>
	function chkJoin() {
			var name = document.querySelector('input[name="name"]');
			var id = document.querySelector('input[name="id"]');
			var pw = document.querySelector('input[name="pw"]');
			var pwChk = document.querySelector('input[name="pwChk"]');
			var birth = document.querySelector('input[name="birth"]');
			var email = document.querySelector('input[name="email"]');
			var hobby = document.querySelectorAll('input[name="hobby"]');
			var cnt = 0;
			for (var i = 0; i<hobby.length ; i++){
				cnt += hobby[i].checked;
			}
			if(name.value==null || name.value==""){
				alert('이름을 입력해주세요');
				name.focus();
				return false;
			}else if(id.value==null || id.value==""){
				alert('아이디를 입력해주세요');
				id.focus();
				return false;
			}else if(pw.value==null || pw.value==""){
				alert('비밀번호를 입력해주세요');
				pw.focus();
				return false;
			}else if(birth.value==null || birth.value==""){
				alert('생일을 입력해주세요');
				birth.focus();
				return false;
			}else if(!cnt){
				alert('취미를 한개 이상 선택하셔야 합니다');
				return false;
			}else if(email.value==null || email.value==""){
				alert('이메일을 입력해주세요');
				email.focus();
				return false;
			}
			if(pw.value != pwChk.value){
				alert('비밀번호 확인하세요');
				pw.value='';
				pwChk.value='';
				pw.focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<div id="joinForm_wrap">
		<form action="../exam2/joinPro.jsp" method="post" name="frmJoin" onsubmit="return chkJoin()">
			<div id="join_title">회원가입</div>
			<input type="hidden" name="hiddenParam" value="xx">
			<table>
				<tr>
					<th><label for="name">이름</label></th>
					<td>
						<input type="text" name="name" class="name" id="name" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th><label for="id">아이디</label></th>
					<td>
						<input type="text" name="id" class="id" id="id">
					</td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td>
						<input type="password" name="pw" class="pw" id="pw">
					</td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호</label></th>
					<td>
						<input type="password" name="pwChk" id="pwChk" class="pwChk">
					</td>
				</tr>
				<tr>
					<th><label for="birth">생년월일</label></th>
					<td>
						<input type="date" name="birth" class="birth" id="birth">
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" value="독서" id="reading">
						<label for="reading">독서</label>
						<input type="checkbox" name="hobby" value="요리" id="cooking">
						<label for="cooking">요리</label>
						<input type="checkbox" name="hobby" value="운동" id="exercise">
						<label for="exercise">운동</label>
						<input type="checkbox" name="hobby" value="취침" id="sleep">
						<label for="sleep">취침</label>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="m" id="m" checked="checked">
						<label for="m">남자</label>
						<input type="radio" name="gender" value="f" id="f">
						<label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td>
						<input type="email" name="email" id="email" class="email">
					</td>
				</tr>
				<tr>
					<th>메일 수신</th>
					<td>
						<select name="mailSend" multiple="multiple" class="mailSend" id="mailSend">
							<option>광고</option>
							<option>배송</option>
							<option>공지</option>
							<option>댓글</option>
						</select>
					</td>
				</tr>
				<tr><td colspan="2"></td></tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="뒤로가기" class="joinBtn_style" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="../exam2/footer.jsp"%>
</body>
</html>