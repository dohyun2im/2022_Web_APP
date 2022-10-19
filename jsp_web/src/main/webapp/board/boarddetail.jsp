<%@page import="model.dto.boardDto"%>
<%@page import="model.dao.boardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%@include file="../header.jsp" %>
	<%if(loginid==null){response.sendRedirect("../member/login.jsp");}%>

	<div class="webbox">
		<h3> 글 조회 </h3>
		<table id="detailbox">
		</table>
		<a href="/jsp_web/board/boardlist.jsp">뒤로 가기</a>
		
		<form>
			<input type="text" id="com" name="com">
			<button type="button" onclick="comments()">댓글달기</button>
			<table id="commentbox" class="table">
			</table>
		</form>
	</div>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script type="text/javascript" src="../js/board/boarddetail.js"></script>
</body>
</html>

