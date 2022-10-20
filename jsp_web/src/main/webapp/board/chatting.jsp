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
	<input type="hidden" class='mid' value=<%=loginid%>>
	<%if(loginid==null){response.sendRedirect("../member/login.jsp");}%>
	<div class='webbox'>
		<h3>채팅</h3>
		<div class='contentbox'></div>
		<textarea onkeyup="enterkey()" class='msgbox' rows="" cols=""></textarea>
		<button type="button" onclick="send()">보내기</button>
	</div>
	
	<script src='../js/board/chatting.js' type="text/javascript"></script>
</body>
</html>