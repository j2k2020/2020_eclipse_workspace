<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paramEl.jsp</title>
</head>
<body>
<!-- 파라메타로 부터 받는 이름 --> 
-------------------------------------------------<p>
El이름:${param.name} <p>
JAVA이름:<%=request.getParameter("name") %><p>
<% request.setAttribute("name", "김길동"); %>
이름:${name}<p>
이름:${"박길동"}<p>
-------------------------------------------------<p>
<!-- paramValues 값이 여러개인 파라메타는~ value의 이름이 모두 같기 때문에 같이 받을 수 있음--> 
※좋아하는 과목:<p> 
${paramValues.lang[0]},
${paramValues.lang[1]},
${paramValues.lang[2]},
${paramValues.lang[3]}<p>

-------------------------------------------------<p>
※내장 객체를 이용한 EL표현:<p>
<% pageContext.setAttribute("subjects", new String[]{"C","C++","JAVA","Python"}); %>
${subjects[0]},${subjects[1]},${subjects[2]},${subjects[3]}<p>
-------------------------------------------------<p>
<!-- input테그의 value의 값명으로 출력 -->
※폼에서 전송된 이름이 같은 데이터:<p>
<% String[] lang=request.getParameterValues("lang"); %>
<%=lang[0] %>,<%=lang[1] %>,<%=lang[2] %>,<%=lang[3] %>
<p>
<% pageContext.setAttribute("langs",lang); %>
${langs[0]},${langs[1]},${langs[2]},${langs[3]}
</body>
</html>



















