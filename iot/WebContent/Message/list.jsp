<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Message_up List</title>
</head>
<body>
<div class="container">
 <h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>메시지 전체 리스트</h2>

<form action="search_list.jsp" method=post>
<div class="form-group">
<select name=field>
<option value=name>이름</option>
<option value=content>메시지</option>
</select>
<!--     <input type="text" name="name" placeholder="찾을 내용을 입력하세요"> -->
<input type="text" name="search" placeholder="찾을 내용을 입력하세요"> 
<button type="submit" class="btn btn-default">검색</button>
</div>    
</form>

<table class="table">

<tr class="danger">
<th>번호</th><th>이름</th><th>메시지</th>
</tr>
<%

try{
	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");

   int requestPage=1; //요청한 페이지
   String _requestPage=request.getParameter("requestPage"); 
System.out.println("requestPage:"+_requestPage);
   
   //_requestPage가 널이 아닐 때, 값을 받아온다.
   if(_requestPage!=null){
   requestPage=Integer.parseInt(_requestPage); }
   System.out.printf("requestPage:%d\n", requestPage);
   
   //전체 페이지에 대한 수를 구해야 된다.
   String sql="Select * from message"; //전체 사용 asc/desc
   PreparedStatement pstmt=conn.prepareStatement(sql);
   ResultSet rs=pstmt.executeQuery();
   //1.전체 글의 갯수
   int totalCount=0; 
   while(rs.next()) totalCount++; 
   
   int countPerPage=10;   //2.페이지당 글의 갯수
   //전체 페이지 수가 구해져야, 요청한 페이지의 시작 글번호와 끝 글번호가 나오기 때문( 해당하는 페이지의 글 번호가 자동으로 계산 됨↓)
   int firstRow=(requestPage-1)*countPerPage+1;
       if(firstRow<1){ firstRow=0; }

   int endRow=firstRow+countPerPage-1;
       if(endRow>totalCount){ endRow=totalCount; }
        
   //3.전체페이지수
   int totalPageCount=0;
     if(totalCount%10==0){
	       totalPageCount=(totalCount/countPerPage);
     }else{
	       totalPageCount=(totalCount/countPerPage)+1; }

     

int startPage=1;//시작페이지
if(startPage<1){startPage=1;}

int endPage=1;//끝페이지
if((startPage+4)>totalPageCount){
	endPage=totalPageCount;
}else{
	endPage=startPage+4;
}
if(endPage>totalPageCount){endPage=totalPageCount;}


//sql="Select*from message where no>=firstRow and no<=endRow"; 
//sql="Select*from message where no<=? and no>=? order by no desc"; //최신글 부터 보려면 번호 순번도 변경해야 됨.
sql="Select*from message where no>=? and no<=? order by no asc";
pstmt=conn.prepareStatement(sql);
pstmt.setInt(1, firstRow); //asc
pstmt.setInt(2, endRow); //asc

//pstmt.setInt(1, totalCount-endRow); //desc
//pstmt.setInt(2, totalCount-firstRow); //desc
rs=pstmt.executeQuery();

while(rs.next()) {
%>
<!-- 글에 대한 내용 -->
<tr>
<td><%=rs.getInt("no") %></td> <td><a href='print_search_proc.jsp?name=<%=rs.getString("name")%>'><%=rs.getString("name")%></a></td> 
<td><%=rs.getString("content") %></td>
</tr>
<%} //while end! 
%>
<!-- 페이지 넘기기 -->
<tr>
<td colspan=2 align=center>
 <ul class="pagination">
 <% if(requestPage!=1){ %> <!-- 요청한 페이지가 1이 아닐때 -->
    <li class="page-item"><a class="page-link" href="list.jsp?requestPage=<%=requestPage-1%>">이전페이지</a></li>
    <%}%>
    <% for(int i=startPage;i<=endPage;i++){ %>
    <li class="page-item"><a class="page-link" href="list.jsp?requestPage=<%=i%>"><%=i%></a></li>
    <% } %>
    <% if(totalPageCount!=requestPage){ %>
    <li class="page-item"><a class="page-link" href="list.jsp?requestPage=<%=requestPage+1%>">다음페이지</a></li>
    <%} %>
  </ul>
</td>
<td valign="center">
<button onclick="location.href='Message_form.jsp'" >글쓰기</button>
</td>
</tr>


</table>
<%
rs.close();
pstmt.close();
conn.close();
}catch(Exception e){}
finally{}
%>
</div>
</body>
</html>