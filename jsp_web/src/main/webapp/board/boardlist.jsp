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
	<%if(loginid==null){response.sendRedirect("/jsp_web/member/login.jsp");}%>
	<div class="webbox">
		<div class="box">
			<h1>게시물 목록 </h1>
			<a href="/jsp_web/board/boardwrite.jsp">글쓰기</a>
			<div>총 게시물 수:<span class="totalpage"></span></div>
			<div>
				<select class='listsize' onchange="blistsize()">
					<option value='5'>5</option>
					<option value='10'>10</option>
					<option value='15'>15</option>
					<option value='20'>20</option>
				</select>
			</div>
			<table class="table" id="viewbox">
			</table>
			<div class='pagebox'></div>
			<div class='search'>
				<select class='key'>
					<option value='b.btitle'>제목</option>
					<option value='b.bcon'>내용</option>
					<option value='m.mid'>작성자</option>
				</select>
				<input class='keyword' type="text" placeholder="검색어">
				<button type="button" onclick="bsearch()">검색</button>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="../js/board/board.js" type="text/javascript"></script>
</body>
</html>