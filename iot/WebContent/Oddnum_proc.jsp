<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int x=Integer.parseInt(request.getParameter("x"));
  String result="짝수";
  if(x%2==0){ result="짝수";} 
  else { result="홀수";}
  System.out.println(result);
  request.setAttribute("result", result);
  //response.sendRedirect("Oddnum_view.jsp");
  
  //setAttribute사용하여 저장하고, sendRedirect()함수를 호출할 경우 값이 전달 안됨.
  RequestDispatcher dispatcher=request.getRequestDispatcher("Oddnum_view.jsp"); 
			
  dispatcher.forward(request,response);
%>
</body>
</html>