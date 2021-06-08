<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El 논리_관계 연산(logic_relative.jsp)</title>
</head>
<body>
--------------------------------------------<p>
◎ 논리연산 ◎<p>
--------------------------------------------<p>
and 연산 : ${true && true}, ${true and false}<p>
or 연산   : ${true || true}, ${true or false}<p>
not 연산 : ${!true}, ${not false}<p>
--------------------------------------------<p>

◎ 관계연산 ◎<p>
--------------------------------------------<p>
> :<br> 
10 > 11 : ${10 > 11}<br>
10 gt 11 : ${10 gt 11}<p> <!-- gt=grate -->
< : ${10 < 11}, ${10 lt 11}<p>
>=: ${10 >= 11}, ${10 ge 11}<p>
<=: ${10 <= 11}, ${10 le 11}<p>
==: ${10 == 11}, ${10 eq 11}<p>
!=: ${10 != 11}, ${10 ne 11}<p>
--------------------------------------------<p>
<% pageContext.setAttribute("title", "login"); %>
◎ 비어있다 empty : ${empty tile}, ${empty title2}<p> <!-- empty는 찾고자 하는 데이터가 있는지 없는지 물어보는 것 -->
--------------------------------------------<p>
</body>
</html>



