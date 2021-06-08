<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>map.jsp</title>
</head>
<body>
<p>
---------------------------------------<p>
MAP(지정한 곳에 따라가서 가지고 온다)<br>
---------------------------------------<p>
<!-- map에 대한 객체 생성 -->
<%
Map<String, String> map=new HashMap(); 
map.put("Insert.do","class insert");
map.put("List.do","class select");
map.put("Delete.do","class delete");
map.put("update.do","class update");

pageContext.setAttribute("map",map);
%>
<!-- map을 java문법으로 들고올 때 -->
JAVA문법:
<%=map.get("List.do") %>

<p>
EL문법:
${map[Delete.do"]}
<p>
</body>
</html>



















