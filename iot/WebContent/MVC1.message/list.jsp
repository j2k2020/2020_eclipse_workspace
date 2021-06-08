<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.iot.web.ConnectionPool" %>
<%@ page import="message.Message" %>
<%@ page import="java.util.ArrayList, java.util.List" %>

<%		

		//변수 선언은 try위로 다 올려야합니다.
		Connection conn;
		int requestPage=1;
		String _requestPage;
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		//전체 글의 갯수 ******
		int totalCount=0;
		//페이지당 글의 갯수 ********
		int countPerPage=10;
		int firstRow;
		int endRow;
		int startPage=1;
		int endPage=1;
		int totalPageCount=0;
		List<Message> list=new ArrayList<Message>();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
	
			if(conn==null) {System.out.println("DB접속에 실패");}
			System.out.println("DB접속 성공");
		//1.요청한 페이지번호
		_requestPage=request.getParameter("requestPage");
		//System.out.printf("requestPage:%s\n", _requestPage);
		if(_requestPage!=null)
		{requestPage=Integer.parseInt(_requestPage);}
		System.out.printf("requestPage:%d\n", requestPage);
		
		//2.전체페이지 수를 구해야함.
		//2.전체 게시물 수를 구함.
		sql="select * from message";
		pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		rs=pstmt.executeQuery();
		while(rs.next()) totalCount++;
		System.out.println("totalCount:"+totalCount);
		
		
		//3.전체페이지수 구하기******
				if(totalCount%10==0){
				totalPageCount=(totalCount/countPerPage);
				}else{
				totalPageCount=(totalCount/countPerPage)+1;
				}
				System.out.println("totalPageCount:"+totalPageCount); 
				
				//4.시작페이지 구하기
				if(startPage<1){startPage=1;}
				//끝페이지 구하기
				//int endPage=startPage+4;
				if((startPage+4)>totalPageCount){
				   endPage=totalPageCount;
				}else{
				   endPage=startPage+4;
				}
				if(endPage>totalPageCount){endPage=totalPageCount;}
				
				
		//5.페이지에 대한 시작 글 번호,끝 글 번호 구함. 
	   firstRow=totalCount-(requestPage-1)*countPerPage;
	   endRow=firstRow-countPerPage;		
	
		sql="select * from message where no>? and no<=? order by no desc"; //desc(최근글), asc(이전글)
		pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		pstmt.setInt(1, endRow); 
		pstmt.setInt(2, firstRow);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			Message msg=new Message();
			msg.setNo(rs.getInt("no"));
			msg.setName(rs.getString("name"));
			msg.setContent(rs.getString("content"));
			list.add(msg);
		}
		rs.close();
		pstmt.close();
		conn.close();
		}catch(Exception e){}
		finally{}
%>

<!DOCTYPE html>
<html>
<head>
<script>
function dataCheck(){
	if(document.getElementById("search").value==""){
		alert("검색 내용을 입력해 주세요")
		document.getElementById("search").focus();
		return;
	}
	
	document.form.submit();
	
}
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Page Message List</title>
</head>
<body>
<div class="container">
<h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>메시지 전체 리스트</h2>
 <form name=form action="search_list.jsp" method=post>
 	<div class="form-group">
 	<select name=field>
 	<option value=name>이름</option>
 	<option value=content>메시지</option>
 	</select>
    <input type="text" name="search" placeholder="찾을 내용을 입력하세요">
    <button type="button" onclick=dataCheck() class="btn btn-default">검색</button>
    </div>
 </form>
<table class="table">

<tr class="success">
<th>번호</th><th>이름</th><th>메시지</th>
</tr>

<%//반복문 시작 %>
<% for(int i=0;i<list.size();i++){ 
	Message msg=list.get(i);
%>
<tr onclick="location.href='print_search_proc.jsp?no=<%=msg.getNo() %>'">
<td><%=msg.getNo()%></td>
<td onmouseover="this.style.backgroundColor='lightgray'"><%=msg.getName()%></td>
<td><%=msg.getContent()%></td>
</tr>
<%} %>
<%//반복문 끝 %>

<tr>
<td colspan=2 align=center valign=middle>
<ul class="pagination">
    <% if(requestPage!=1){ %>
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
<td>
<button onclick="location.href='Message_form.jsp'">글쓰기</button>
</td>
</tr>
</table>
<%

%>
</div>
</body>
</html>