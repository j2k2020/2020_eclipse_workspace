<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    
<!-- page지시자의 예외처리 부분은 isErrorPage속성을 사용한다고 정의를 해야, 에러가 발생하지 않음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
에러가 발생했습니다.<br>
<%=exception.getMessage() %><br>
<%=exception.getStackTrace() %>
</body>
</html>