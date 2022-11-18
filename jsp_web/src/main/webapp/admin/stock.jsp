<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class='container'>
		<h3>재고 관리</h3>
		<div class='row my-3'>
			<div class='col-md-4'>
				<select class='categorybox form-select'>
					<option>카테고리 선택</option>
				</select>
			</div>
			
			<div class='col-md-4'>
				<select class='productbox form-select'>
					<option>제품 선택</option>
				</select>
			</div>
		</div>
	
		<div class='row my-3'>
			
			<div class='col-md-6'>
				<h3>재고 등록</h3>
				<table class='table'>
					<tr><td style="width: 20%;">카테고리 번호</td> <td class='rows'></td> </tr>
					<tr><td style="width: 20%;">제품 번호</td>    <td class='rows'></td> </tr>
					<tr><td style="width: 20%;">제품 이름</td>    <td class='rows'></td> </tr>
					<tr><td style="width: 20%;">사이즈</td>	   <td class='rows'><input type="text" class='psize form-control'></td> </tr>
					<tr><td style="width: 20%;">색상</td> 	   <td class='rows'><input type="text" class='pcolor form-control'></td> </tr>
					<tr><td style="width: 20%;">재고</td> 	   <td class='rows'><input type="text" class='pstock form-control'></td> </tr>
					<tr><td colspan="2"><button type="button" onclick='setstock()' class='form-control'>등록</button></td></tr>
				</table>
			</div>
			
			<div class='col-md-6'>
				<h3>재고 출력</h3>
				<table class='table stockoutput'>
					
				</table>
			</div>
		</div>
	
	</div>
	
	
	
	<script src="/jsp_web/js/admin/stock.js" type="text/javascript"></script>
</body>
</html>