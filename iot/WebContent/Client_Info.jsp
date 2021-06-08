<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client Information</title>
<!-- http://192.168.0.10:9090/clientInfo.jsp으로 접속해서 확인~ -->
당신의 IP주소는 <%=request.getRemoteAddr() %>입니다.<p>
getLocalPort는 -> <%=request.getLocalPort() %><br>
URI는 -> <%=request.getRequestURI() %><br>
URL는 -> <%=request.getRequestURL() %><p>
getHeader는 ↓ <p>
Accept -> <%=request.getHeader("Accept") %><br>
User-agent -> <%=request.getHeader("User-agent") %><br>
Cookie -> <%=request.getHeader("Cookie") %><br>
Date -> <%=request.getHeader("Date") %><br>
Connection -> <%=request.getHeader("Connection")%>


</head>
<body>

</body>
</html>