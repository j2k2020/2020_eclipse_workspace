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
<title>list.jsp</title>
</head>
<body>
---------------------------------------<p>
LIST(있는걸 그대로 가지고 온다)<br>
---------------------------------------<p>
<!-- List에 대한 객체 생성 -->
<% //List<String> list=new ArrayList(); 
List<String> list=new LinkedList(); 
list.add("111");
list.add("222");
list.add("333");
pageContext.setAttribute("list", list);
%> 
<!-- list를 java문법으로 들고올 때 -->
JAVA문법:
<%=list.get(2)%>
<!-- list를 el로 들고올 때 -->
EL문법:
${list[0]},
${list[1]},
${list[2]}
<p>

<p>
---------------------------------------<p>
MAP(지정한 곳에 따라가서 가지고 온다)<br>
---------------------------------------<p>
<!-- map에 대한 객체 생성 -->
<%
Map<String, String> map=new HashMap(); 

//<String, String> Map은 한쌍으로 찾는 것  map.put("1", "a");
//<Integer, String> map=new HashMap();은 map.put(1, "a");
//map은 list와 다르게 배열로 찾는게 아니라, 변수형으로 찾는 것이기 때문에 문자와 숫자의 구분이 필수!
map.put("1", "a");
map.put("2", "b");
map.put("3", "c");

map.put("Insert.do","class insert");
map.put("List.do","class select");
map.put("Delete.do","class delete");
map.put("update.do","class update");

pageContext.setAttribute("map",map);
%>
<!-- map을 java문법으로 들고올 때 -->
JAVA문법:
<%=map.get("2")%><br>
<%=map.get("Insert.do") %>

<p>
EL문법:
${map["1"]}<br>
${map["Delete.do"]}
<p>
</body>
</html>



















