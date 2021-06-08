<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c lib tag (ctag.jsp)</title>
</head>
<body>
<c:out value="${'hello'}" />${hello}
<c:set var="i" value="${1}" /> i변수를 선언 <!-- 변수 만들어서 출력 -->
<c:remove var="i" /> i변수를 제거

<c:forEach var="i" begin="${1}" end="${10}"> 반복문을 사용하기 위한 테그 라이브러리
hello
</c:forEach>

<c:if test="${1!=0}"> 
참 입니다.
</c:if>

<!-- choose 의 when,otherwrise는 if,else의 구문이랑 같다. -->
<c:choose> 
<c:when test="${10>9}">
참일 때 실행
</c:when>
<c:otherwise>
거짓일 때 실행
</c:otherwise>

</c:choose>

</body>
</html>