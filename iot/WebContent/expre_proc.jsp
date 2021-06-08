<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name=request.getParameter("name"); %> <!-- 지역변수 (여기서만 사용되고 끝~) -->

표현식에 대해 알아봅시다<br>
<!-- 1 --><%=request.getParameter("name") %><br> <!-- 전역변수 (여러곳에서 사용, 불러오는것(=)은 (;)이 필요x) -->

<!-- 2 --><%=name %><br>

<!-- 3 --><jsp:expression>name</jsp:expression><br>

<!-- 4 --><% request.setAttribute("exp_name",name); %>
           ${exp_name}<br> <!-- java에서 많이 사용 -->

<!-- 5 --><% out.println(name); %>
</body>
</html>

<!-- 어디서 사용하는 방법일까? 
<%-- <%! String g_name="홍길동"; %> --%> 
${g_name}  -->
