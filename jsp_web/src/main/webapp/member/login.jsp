<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class=webbox>
		
		
		<h1>form 동기식 로그인 페이지</h1>
		<form action="/jsp_web/member/login" method="post">
			아이디 : <input type="text" name="mid"><br>
			비밀번호 : <input type="password" name="mpw"><br>
			<input type="submit" value="로그인"><br>
		</form>
		
		<br>
		
		
		<h1>ajax 이용 비동기식 로그인 페이지</h1>
		아이디 : <input type="text" id="mid"><br>
		비밀번호 : <input type="password" id="mpw"><br>
		<div id="loginconfirmbox"></div>
		<button type="button" onclick="login()" id="로그인">로그인</button>
		
		<ul>
			<li><a href="/jsp_web/member/findid.jsp">아이디찾기</a></li>
			<li><a href="/jsp_web/member/findpw.jsp">비밀번호찾기</a></li>
		</ul>
		
	</div>
	<script src="../js/member/login.js" type="text/javascript"></script>
</body>
</html>