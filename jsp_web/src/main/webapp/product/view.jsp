<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href='/jsp_web/css/product/view.css' rel='stylesheet'>
</head>
<body>
	<%@include file="../header.jsp" %>
	<%
	if(request.getParameter("pno")==null){
		response.sendRedirect("/jsp_web/index.jsp");
	}
	Object object = session.getAttribute("mid");
	String mid = null;
	if(object!=null){
		mid = (String)object;
	}
	int pno = Integer.parseInt(request.getParameter("pno")); %>
	
	<input type="hidden" value="<%=mid%>" class='mid'>
	<input type="hidden" value="<%=pno%>" class='pno'>
	<div class='container'>
		<div class='row'>
			<div class='col-md-6'>
				<img src="" class='pimg'>
			</div>
			<div class='col-md-6'>
				<div class='infobox'>
					<h4 class='pname'></h4>
					<div class='pcon'></div>
					<div class='pricebox'></div>
					<div class='sizebox'>
					</div>
					<table class='table info_table'>
						<tr><td>배송구분</td><td>2,500(70,000원 이상 구매 시 무료)</td></tr>
						<tr><td>카드혜택</td><td>무이자 할부</td></tr>
						<tr><td>적립혜택</td><td>3,000 (1%)</td></tr>
						<tr>
							<td>색상</td>
							<td>
								<select class='form-select cselect coloroption'>
									<option>색상선택</option>
									<option>블랙</option>
									<option>화이트</option>
									<option>카키</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>사이즈</td>
							<td>
								<select class='form-select cselect sizeoption'>
									<option>사이즈선택</option>
									<option>S</option>
									<option>M</option>
									<option>L</option>
								</select>
							</td>
						</tr>
					</table>
					<table class='table select_t'>
						<tr>
							<th width='60%'>상품명/옵션</th> 
							<th width='20%'>수량</th> 
							<th width='20%'>가격</th>
						</tr>
					</tablse>
					<div class='row'>
						<div class='col-md-6'>총 상품금액</div>
						<div class='col-md-5 totalprice'></div>
					</div>
					<div class='btnbox'>
						<button id='btn1'>바로구매</button>
						<button class='btncart'>장바구니 등록</button>
						<button id='btn3' class='btnlike'>찜하기 ♥</button>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script src='/jsp_web/js/product/view.js' type="text/javascript"></script>
</body>
</html>