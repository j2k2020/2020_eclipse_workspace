<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add_proc.jsp">
<!-- 
<%=request.getParameter("x") %>+<%=request.getParameter("y") %>=
<%=Integer.parseInt(request.getParameter("x"))+Integer.parseInt(request.getParameter("y")) %>
 -->
 
 
<%
int x=Integer.parseInt(request.getParameter("x"));
int y=Integer.parseInt(request.getParameter("y"));
int sum=x+y;
%>
<%=x%>+<%=y%>=<%=sum%>

</body>
</html>