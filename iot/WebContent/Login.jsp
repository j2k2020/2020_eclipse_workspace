<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<% 
String id=request.getParameter("id");
String password=request.getParameter("password");

//id,password 확인하는 작업
//원래는 데이터베이스에서 아이디,패스워드를 검색해서 진행해야됨. 현재 데이터배이스가 없으니 그냥 진행한다.
if(id.equals("user") && password.equals("1234")){
	session.setAttribute("id", id); //(string,object)
	//사용자 시간 저장
	session.setMaxInactiveInterval(20); //20초뒤 자동으로 해지
	
	//로그인 세션을 제공하고, 로그인된 페이지로 이동
	response.sendRedirect("logined_page.jsp");
}else{
	//로그인 실패시 페이지로 이동
	response.sendRedirect("logouted_page.jsp");
	
}
%>


<%-- <%
String id=request.getParameter("id");
String password=request.getParameter("password");
String remeber=request.getParameter("remeber");

 아이디:<%=id%><br>
 패스워드:<%=password %><br>
 저장여부:<%=remeber %><br>
--%>

</body>
</html>