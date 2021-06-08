<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <title>Insert title here</title> <!-- Bootstrap 4 Pagination -->
</head>
<body>
<%
//전체 글의 갯수
int totalCount=91;
//페이지당 글의 갯수
int countPerPage=10;
//전체 페이지 수
//int totalPageCount=(totalCount/countPerPage)+1;
int totalPageCount;
if(totalCount%10==0){
	totalPageCount=(totalCount/countPerPage);
}else{
	totalPageCount=(totalCount/countPerPage)+1;
}
%>
<div class="container">
  <h2>게시판 리스트</h2>
  <p>게시판 페이지 연습</p>
   <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">이전 페이지</a></li>
    <% for(int i=1; i<=totalPageCount; i++) {%>
    <li class="page-item"><a class="page-link" href="#"><%=i %></a></li>
    <%} %>
    <li class="page-item"><a class="page-link" href="#">다음 페이지</a></li>
  </ul>
</div>

</body>
</html>
