<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jsp_web/css/dashboard.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%
	String mid = (String)session.getAttribute("mid");
	if(mid==null|| !mid.equals("admin")){
		response.sendRedirect("../member/login.jsp");
	}
	%>
	<marquee scrollamount="10"> 공지사항 표시되는 위치</marquee>
	
	<div class='sidebar'>
		<h2>관리자 메뉴</h2>
		<ul class='sidemenu'>
			<li class='side_item'><a onclick='pagechange("regist.jsp")'>제품 등록</a></li>
			<li class='side_item'><a onclick='pagechange("list.jsp")'>제품 목록</a></li>
			<li class='side_item'><a onclick=''>재고 관리</a></li>
			<li class='side_item'><a onclick=''>주문 관리</a></li>
			<li class='side_item'><a onclick=''>매출 관리</a></li>
			<li class='side_item'><a onclick=''>회원 목록</a></li>
			<li class='side_item'><a onclick=''>배송 관리</a></li>
			<li class='side_item'><a href="/jsp_web/member/logout.jsp">로그 아웃</a></li>
		</ul>
	</div>
	
	<div id='mainbox'>
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jsp_web/js/admin/dashboard.js" type="text/javascript"></script>
</body>
</html>