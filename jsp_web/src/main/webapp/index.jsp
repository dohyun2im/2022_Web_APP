<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="/jsp_web/css/main.css" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class='container'>
		<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" data-bs-interval='4000'>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="/jsp_web/img/main/main.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jsp_web/img/main/main2.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jsp_web/img/main/main3.jpg" class="d-block w-100" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/jsp_web/img/main/main4.jpg" class="d-block w-100" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
		</div>	
	</div>
	
	<div class='container'>
		
		<h6 class='box_title'>New product</h6>
		
		<div class='itemlist'>
		</div>
	</div>
	
	<div style="width: 500px; height: 300px;">
      <!--차트가 그려질 부분-->
      <canvas id="myChart"></canvas>
   </div>
   
   
   
   
   
   
   
   
   <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script src="/jsp_web/js/index.js" type="text/javascript"></script>
</body>
</html>