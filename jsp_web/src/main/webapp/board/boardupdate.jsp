<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 썸머노트 -->
	<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<%if(loginid==null){response.sendRedirect("/jsp_web/member/login.jsp");}%>
	<div class="webbox">
		<div class="box">
			<h1>수정할 게시물 작성 </h1>
			<form>
			제목: <input type="text" id="btitle" name="btitle"><br>
  			<textarea id="summernote" name="bcon"></textarea><br>
			첨부파일:<input type="file" id="bfile" name="bfile"><br>
			<button type="button" onclick="update()">전송</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="lang/summernote-ko-KR.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="../js/board/boardupdate.js" type="text/javascript"></script>
</body>
</html>