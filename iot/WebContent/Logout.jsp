<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<% 
//세션 해제 방법 3가지
session.invalidate();  //1st 완전
//session.removeAttribute("id"); //2nd id만비교
//session.setAttribute("id",null); //3rd id가 널값을 때
response.sendRedirect("logouted_page.jsp");

%>

</body>
</html>