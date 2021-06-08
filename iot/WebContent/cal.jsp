<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=cal_proc.jsp method=post>
x: <input type=text name=x> y:<input type=text name=y><br>
<input name=operator type=radio value=1>더하기<br>
<input name=operator type=radio value=2>빼기<br>
<input name=operator type=radio value=3>곱하기<br>
<input name=operator type=radio value=4>나누기<br>
<input type=submit value=계산하기>
</form>

</body>
</html>