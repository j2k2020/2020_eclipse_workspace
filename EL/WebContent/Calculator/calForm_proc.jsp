<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El식으로 계산하기(calForm_proc.jsp)</title>
</head>
<body>
더하기 : ${param.x+param.y}<p>
빼기 : ${param.x-param.y}<p>
곱하기 : ${param.x*param.y} <p>
나누기 : ${param.x/param.y}, ${param.x div param.y} <p>
나머지 : ${param.x%param.y}, ${param.x mod param.y} <p>
</form>
</body>
</html>