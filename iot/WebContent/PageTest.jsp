<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %> <!-- 지시어가 page이다, import여기에 쓰겠다는 뜻  -->
    <%@ page info="pageTest중입니다." %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
java.util.Calendar cal=java.util.Calendar.getInstance();
%>
<%-- 
<%=cal.get(java.util.Calendar.YEAR) %>년<br>
<%=cal.get(java.util.Calendar.MONTH)+1 %>월<br>
<%=cal.get(java.util.Calendar.DATE) %>일<br>
--%>
<%=cal.get(Calendar.YEAR) %>년
<%=cal.get(Calendar.MONTH)+1 %>월
<%=cal.get(Calendar.DATE) %>일
<%=cal.get(Calendar.HOUR_OF_DAY) %>시간
<%=cal.get(Calendar.MINUTE) %>분
<%=cal.get(Calendar.SECOND) %>초
<br>
<%=this.getServletInfo() %>
 추워ㅠ.ㅠ~~
</body>
</html>