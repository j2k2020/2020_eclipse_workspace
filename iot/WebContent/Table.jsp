<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- jsp에서 사용하는 테크(지시어) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width=50%>

<tr><th>번호</th><th>가격</th></tr>
<% for(int i=1; i<=10; i++){ %>
<tr><th><%=i%></th><th><%=i*1000%></th></tr>
<%} %>
</table>
</body>
</html>