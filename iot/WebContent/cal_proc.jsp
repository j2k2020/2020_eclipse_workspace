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

<%
int x=Integer.parseInt(request.getParameter("x"));
int y=Integer.parseInt(request.getParameter("y"));
int operator=Integer.parseInt(request.getParameter("operator"));
float result=0;
%>
<!-- switch()문으로 결과를 계산하고 결과를 출력하세요 -->
<%
switch(operator){
case 1: 
	result=(float)(x+y); break;
case 2: 
	result=(float)(x-y); break;
case 3: 
	result=(float)(x*y); break;
case 4: 
	result=(float)x/(float)y; break;
default: break;
}
%>

결과출력: <%=result %>


</body>
</html>