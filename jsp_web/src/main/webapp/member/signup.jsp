<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/signup.css">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class=webbox>
		<form class="signupform" action="/jsp_web/member/signup" method="post">
			<h1 class="pagetitle">회원가입 페이지</h1>
			<h3 class="parttitle">기본정보</h3>
			<table class="signuptable">
				<tr>
					<td class="col1">아이디 :</td>
					<td class="col2"><input type="text" id="mid" name="mid" onkeyup="mevent1()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 : </td>
					<td class="col2"><input type="password"  id="mpw" name="mpw" onkeyup="mevent2()"></td>
					<td rowspan="2" class="col3"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호확인 :</td>
					<td class="col2"><input type="password" id="mconpw" name="mconpw" onkeyup="mevent3()"></td>
				</tr>
				<tr>
					<td class="col1">이름 :</td>
					<td class="col2"><input type="text"	 id="mname"   name="mname" onkeyup="mevent4()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">전화번호 :</td>
					<td class="col2"><input type="text" 	id="mpn"	name="mpn" onkeyup="mevent5()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">이메일 :</td>
					<td class="col2"><input type="email" id="memail"	name="memail" onkeyup="mevent6()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td rowspan="2" class="col1">주소 :</td>
					<td colspan="2" class="col2">
						<span>
							<input type="text" id="sample4_postcode" placeholder="우편번호" name="addr1">
							<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						</span>
						<span>
							<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr2">
							<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr3">
						</span>
					</td>	
				</tr>
				<tr>
					<td class="col2"><input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addr4"></span></td>
					<td class="col3"></td>
				</tr>
			</table>
			
			<span class="confirmbox">
				<h3 class="parttitle">이용약관</h3>
				<textarea readonly="readonly"></textarea>
				<input id="chk1" type="checkbox"><span>[필수] 이용약관동의</span>
				<textarea readonly="readonly"></textarea>
				<input id="chk2" type="checkbox"><span>[필수] 개인정보 수집동의</span>
			</span>
			
			<div class="signupbtnbox">
				<button type="button" onclick="formsubmit()">회원가입</button>
				<button type="reset">취소</button>
			</div>
		</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="../js/member/signup.js"></script>
</body>
</html>