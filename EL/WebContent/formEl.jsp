<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formEl.jsp</title>
</head>
<body>
<form action=paramEl.jsp>
이름:<input type=text name=name><p>

※좋아하는 프로그래밍 언어를 선택하세요!<br>
<input type=checkbox name=lang value=c>C
<input type=checkbox name=lang value=c++>C++
<input type=checkbox name=lang value=java>JAVA
<input type=checkbox name=lang value=python>Python<p>

<input type=submit value="전송"><p>
</form>
</body>
</html>