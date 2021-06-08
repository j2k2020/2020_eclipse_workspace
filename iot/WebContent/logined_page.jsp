<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logined_page</title>
</head>
<body>
<% 
if(session.getAttribute("id")!=null){%>	<!-- **중요** -->
로그인되었습니다~!<p>
<a href="Logout.jsp">로그아웃</a>
<% }else {
response.sendRedirect("login_form.jsp");
}%>
</body>
</html>