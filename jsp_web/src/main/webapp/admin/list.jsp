<%@page import="model.dto.productDto"%>
<%@page import="model.dao.productDao"%>
<%@page import="java.util.ArrayList"%>
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
		<table class='table'>
			<tr>
			</tr>
		</table>
	</div>
	<!-- 부트스트랩 모달 -->
	<!-- Button trigger modal -->
	<button style="display: none;" type="button" class="updatemodal btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
	</button>

<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
 	 <div class="modal-dialog">
       <div class="modal-content">
     	
     	<div class="modal-header">
     	   <h1 class="modal-title fs-5" id="staticBackdropLabel">제품 수정 창</h1>
     	</div>
     	
    	<div class="modal-body">
    	   <form>
    	   		제품번호 : <input type="text" name="pno" class='pno' readonly="readonly"><br>
    	   		카테고리 : <span class='pcategorybox'></span>
				상품상태:<span></span><input type="radio" name="pactive" class='pactive' value='0'>준비중
						 <input type="radio" name="pactive" class='pactive' value='1'>판매중
						 <input type="radio" name="pactive" class='pactive' value='2'>재고없음</span><br>
						 
				제품명 :  <input type="text" name="pname"class='pname'><br>
				설명 :   <textarea rows="" cols="" name="pcomment" class='pcomment'></textarea><br>
				가격 :   <input type="text" name="pprice" class='pprice'><br>
				할인율 :  <input type="text" name="pdiscount" class='pdiscount'><br>
				
				대표이미지 : <input type="file" id="pimg" name="pimg" class='pimg'><br>
			</form>
    	</div>
    	
       <div class="modal-footer">
        <button type="button" class="pupdate btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" onclick='updateproduct()'>수정</button>
   	   </div>
   	   
  	  </div>
 	 </div>
	</div>
	<script src='/jsp_web/js/admin/list.js' type="text/javascript"></script>
</body>
</html>