<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "../header.jsp" %>
	<%
		session.setAttribute("mid", null);
		//session.invalidate(); // 모든 세션 지워줌
		response.sendRedirect("/jsp_web/index.jsp");
	%>

</body>
</html>