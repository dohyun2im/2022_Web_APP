<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
	<meta name="viewport" content="width=device-width , initial-scale=1.0">
	<link rel="stylesheet" href="/jsp_web/css/header.css">
	<script src="https://kit.fontawesome.com/e128842485.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="webbox">
		<div class="headtop">
			<div>
				<span class="headtitle"><a href="/jsp_web/index.jsp">쇼핑몰</a></span>
			</div>
			<!-- 세션호출 -->
			<%
				//JSP 스크립트 태그
				String loginid = (String)session.getAttribute("mid");
			%>
			<ul class="head_sub">
			<%if(loginid==null){%>
				<li><a href="/jsp_web/member/login.jsp">로그인</a></li>
				<li><a href="/jsp_web/member/signup.jsp">회원가입</a></li>
			<%}else{%>
				<li><%=loginid%>님 안녕하세요 ! </li>
				<li><a href="/jsp_web/member/logout.jsp">로그아웃</a></li>
			<%}%>	
				<li><a href="/jsp_web/member/info.jsp">마이쇼핑</a></li>
				<li><a href="/jsp_web/board/boardlist.jsp">게시판</a></li>
			</ul>
		</div>
		<ul class="head_menu">
			<li><a href="#">sale</a></li>
			<li><a href="#">best</a></li>
			<li><a href="#">베스트</a></li>
			<li><a href="#">티셔츠</a></li>
			<li><a href="#">신발</a></li>
			<li><a href="#">악세사리</a></li>
			<li><a href="#">팬츠</a></li>
			<li><a href="#">코트</a></li>
			<li><a href="#">니트</a></li>
			<li><a href="#">패딩</a></li>
			<li class="searchbox">
				<span>
					<input>
					<i class="fa-solid fa-magnifying-glass"></i>
				</span>
			</li>
			<li>
				<a href="#">
					<i class="fa-solid fa-cart-shopping"></i>
				</a>
			</li>
		</ul>
	</div>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>