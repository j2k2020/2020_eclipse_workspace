<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String id=request.getParameter("id");
String name=request.getParameter("name");
String gender=request.getParameter("gender");
String major=request.getParameter("major");
%>

학번:<%=id %><p>
이름:<%=name %><p>
성별:<%=gender %><p>
학과:<%=major %><p>

</body>
</html>