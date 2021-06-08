<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%
//1.전체 글의 갯수
int totalCount=156;
//2.페이지당 글의 갯수
int countPerPage=10;
//3.전체페이지수
//int totalPageCount=(totalCount/countPerPage)+1;
int totalPageCount;
if(totalCount%10==0){
	totalPageCount=(totalCount/countPerPage);
}else{
	totalPageCount=(totalCount/countPerPage)+1;
}

//리스트 중 요구하는 글번호를 클릭했을 경우
int requestNumber=70;
//해당페이지의 해당페이지 번호,시작글번호, 끝 글번호 
//요청한 글에 대한 페이지 구하기
/*
int startPage;
if(requestNumber%10==0){
	startPage=(requestNumber/countPerPage);
}else{
	startPage=(requestNumber/countPerPage)+1;
}
*/
int startPage=1;
String _startPage=request.getParameter("requestPage");
if(_startPage!=null){startPage=Integer.parseInt(_startPage);}
if(startPage<1){startPage=1;}


//int endPage=startPage+4;
int endPage;
if((startPage+4)>totalPageCount){
	endPage=totalPageCount;
}else{
	endPage=startPage+4;
}
if(endPage>totalPageCount){endPage=totalPageCount;}

//요청한 글번호에 대해 시작글번호 끝 글번호 구하기 (현재 페이지에 대한 내용을 가지고 있어야 됨)
//화면에 나타날 시작 글번호, 끝 글번호 구하기
int requestPage=7;//만약 요청한 페이지가 1이고 글의 갯수가 0개
int firstRow=(requestPage-1)*countPerPage+1; //61번 첫번째 글
if(firstRow<1){firstRow=0;}

int endRow=firstRow+countPerPage-1;
if(endRow>totalCount){
	endRow=totalCount;
}

%>
<div class="container">
  <h2>게시판 리스트</h2>
  <p>게시판 페이지 연습</p>                  
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="boardpage2.jsp?requestPage=<%=startPage-1%>">이전페이지</a></li>
    <% for(int i=startPage;i<=endPage;i++){ %>
    <li class="page-item"><a class="page-link" href="#"><%=i%></a></li>
    <% } %>
    <li class="page-item"><a class="page-link" href="boardpage2.jsp?requestPage=<%=startPage+1%>">다음페이지</a></li>
  </ul>
</div>

</body>
</html>
