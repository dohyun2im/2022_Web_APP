<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class=webbox>
		<h1>비밀번호 찾기</h1>
		아이디 : <input type="text" id="mid">
		이메일 : <input type="text" id="memail">
		<div id="findpwconfirmbox"></div>
		<button type="button" onclick="findpw()">비밀번호 찾기</button>
	</div>
	<script src="../js/member/findpw.js" type="text/javascript"></script>
	
</body>
</html>