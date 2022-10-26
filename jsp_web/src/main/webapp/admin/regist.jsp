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
		<h1>제품 등록</h1>
		<form>
			제품명 : <input type="text" name="pname"><br>
			설명 : <textarea rows="" cols="" name="pcomment"></textarea><br>
			가격 : <input type="text" name="pprice"><br>
			할인율 : <input type="text" name="pdiscount"><br>
			대표이미지 : <input type="file" id="pimg" name="pimg"><br>
			카테고리 : <button type="button" onclick="pcatehoryview()">카테고리</button><br>
				<span class='pcategorybox'>
				</span>
				<div class='pcategorylist'>
				</div>
			<button onclick='regist()' type="button">등록</button><br> <button type="reset">취소</button>
		</form>
		
		<div>
			<img id="pimgpre" alt="" src="">
		</div>
	
	</div>
	<script src='/jsp_web/js/admin/regist.js' type="text/javascript"></script>
</body>
</html>