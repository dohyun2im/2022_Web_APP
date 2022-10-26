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
	<div class='container'>
		<div>
			<table class='table atable'>
				<tr>
					<th>시군구</th>
					<th>번지/본번/부번</th>
					<th>단지명</th>
					<th>전용면적</th>
					<th>계약년월</th>
					<th>계약일</th>
					<th>거래금액</th>
					<th>층</th>
					<th>건축년도</th>
					<th>도로명</th>
					<th>해제사유발생일</th>
					<th>거래유형</th>
					<th>중개사</th>
				</tr>
			</table>
		</div>
		<div id="map" style="width:100%;height:350px;"></div>
		<div class='detailbox'></div>
		<div class='row'>
			<div class='col-sm-3'>
				<input type="text" class='form-control addrinput'>
			</div>
			<div class='col-sm-1'>
				<button type="button" onclick='addrsearch()' class='btn addrsearch()'>검색</button>
			</div>
		</div>
	
		<table class='table table1'>
			<tr>	<th>약국명</th>	<th>전화번호</th> 	<th>주소</th> 	</tr>
		</table>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d40f06c60842f2088a3b26a2a551958&libraries=services"></script>
	<script src='../js/board/api.js' type="text/javascript"></script>
</body>
</html>