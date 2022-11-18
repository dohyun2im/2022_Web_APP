<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/jsp_web/css/chatting.css">
</head>
<body>
	<%@include file="../header.jsp" %>
	<input type="hidden" class='mid' value=<%=loginid%>>
	<%if(loginid==null){response.sendRedirect("/jsp_web/member/login.jsp");}%>
	<div class="container">
		<div class="col-sm-6 offset-3 chattingbox">
			<div class='row'>
				<div class="col-sm-4">
					
				</div>
				<div class="col-sm-8">
					<div class="my-3 contentbox">
						
					</div>
					<textarea onkeyup="enterkey()" class='msgbox form-control' rows="" cols=""></textarea>
					<div class="row">
						<div class="col-sm-2">
							<button class="dropdown-toggle" type="button" id="emobutton" data-bs-toggle="dropdown">
							이모티콘
							</button>
							<ul style="width: 400px; height: 200px;" class="dropdown-menu">
							</ul>
						</div>
						<div class="col-sm-3 offset-7">
							<button class="form-control" type="button" onclick="send()">보내기</button>
						</div>
					</div>
				</div>
			</div>
			
			
		</div>
	</div>
	
	<script src='../js/board/chatting.js' type="text/javascript"></script>
</body>
</html>