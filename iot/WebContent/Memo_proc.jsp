<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Memo_proc.jsp">
제목:<%=request.getParameter("title") %><br>
내용:<%=request.getParameter("content") %><br>
</form>
</body>
</html>