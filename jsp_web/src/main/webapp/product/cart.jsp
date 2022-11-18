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
	<%if(loginid==null){response.sendRedirect("../member/login.jsp");}%>

	<div class='container'>
		<table class='cart_t'>
		
		</table>
		<button type="button">GO쇼핑</button>
		<button type="button">선택삭제</button>
		<button type="button">전체삭제</button>
		<button onclick='payload()' type="button">결제</button>
	</div>
    <script src='/jsp_web/js/product/cart.js' type="text/javascript"></script>
</body>
</html>