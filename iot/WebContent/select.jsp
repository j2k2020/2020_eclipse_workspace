<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="slectForm_proc.jsp" method=post>
학번:<input type=text name=id><p>
이름:<input type=text name=name><p>
성별:<input type=radio name=gender value=남 checked>남
<input type=radio name=gender value=여 >여<p>
학과:<select name=major>
<option selected value="전기전자학부">전기전자학부</option>
<option value="정보통신공학과">정보통신공학과</option>
<option value="정치사회학부">정치사회학부</option>
<option value="관광레저학부">관광레저학부</option>
</select><p>
<input type=submit value="★전송★">
</form>
</body>
</html>