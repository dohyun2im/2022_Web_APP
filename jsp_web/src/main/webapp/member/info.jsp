<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/signup.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<!-- 세션 이용한 페이지 -->
	<%if(loginid==null){response.sendRedirect("login.jsp");}%>
	<br>
	<div class=webbox>
		<form class="signupform" action="/jsp_web/member/signup" method="post">
			<h1 class="pagetitle">회원정보 페이지</h1>
			<h3 class="parttitle">기본정보</h3>
			<table class="signuptable">
				<tr>
					<td class="col1">회원번호 :</td>
					<td class="col2" id="mno"></td>
				</tr>
				<tr>
					<td class="col1">가입일 :</td>
					<td class="col2" id="mdate"></td>
				</tr>
				<tr>
					<td class="col1">포인트 :</td>
					<td class="col2" id="mpoint"></td>
				</tr>
				<tr>
					<td class="col1">아이디 :</td>
					<td class="col2" id="mid"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 : </td>
					<td class="col2"><input readonly="readonly" type="password"  id="mpw" name="mpw"></td>
					<td class="col3"><button type="button">수정</button></td>
				</tr>
				<tr>
					<td class="col1">이름 :</td>
					<td class="col2"><input readonly="readonly" type="text"	 id="mname"   name="mname"></td>
					<td class="col3"><button type="button" onclick="updateaction()">수정</button></td>
				</tr>
				<tr>
					<td class="col1">전화번호 :</td>
					<td class="col2"><input readonly="readonly" type="text" 	id="mpn"	name="mpn"></td>
					<td class="col3"><button type="button">수정</button></td>
				</tr>
				<tr>
					<td class="col1">이메일 :</td>
					<td class="col2"><input readonly="readonly" type="email" id="memail"	name="memail"></td>
					<td class="col3"><button type="button">수정</button></td>
				</tr>
				<tr>
					<td rowspan="2" class="col1">주소 :</td>
					<td colspan="2" class="col2">
						<span>
							<input readonly="readonly" type="text" id="sample4_postcode" placeholder="우편번호" name="addr1">
							<input readonly="readonly" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						</span>
						<span>
							<input readonly="readonly" type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr2">
							<input readonly="readonly" type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr3">
						</span>
					</td>	
				</tr>
				<tr>
					<td class="col2"><input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addr4"></span></td>
					<td class="col3"><button type="button">수정</button></td>
				</tr>
			</table>
			<div class="signupbtnbox">
				<button type="button" onclick="formsubmit()">회원탈퇴</button>
			</div>
		</form>
	</div>
	<br>
	<!--  <div class="webbox">
		<h3>회원 목록</h3>
		<table id = "memberlisttable">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>주소</th>
				<th>날짜</th>
				<th>포인트</th>
			</tr>
		</table>
	</div>-->
	<script src="../js/member/info.js" type="text/javascript"></script>
</body>
</html>