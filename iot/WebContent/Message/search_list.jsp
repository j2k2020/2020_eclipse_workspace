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
<title>Message List</title>
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

<tr class="danger" class="table-hover">
<th>번호</th><th>이름</th><th>메시지</th>
</tr>
<% 
try{
	//String name=request.getParameter("name");
	//System.out.println(name);
	
	String field=request.getParameter("field");
	String search=request.getParameter("search");
	System.out.println("field:"+field);
	System.out.println("search:"+search);

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


//String sql="Select * from message where name=?"; //전체 사용 asc/desc
//String sql="Select * from message where ? like '%?%'"; //where 필드명 like '%?%' -->값부분외에는 ?가 안 읽힘.	
		
String sql="select * from message where ";
sql+=field;
sql+=" like '%"; //like앞에 꼭~ 한 칸 띄워줘야 구문이 실행됨. 
sql+=search;
sql+="%'"; // where 필드명 like
        
PreparedStatement pstmt=conn.prepareStatement(sql);
ResultSet rs=pstmt.executeQuery();

while(rs.next()) {
%>
<tr class="success">
<td><%=rs.getInt("no") %></td><td><%=rs.getString("name") %></td><td><%=rs.getString("content") %></td>
</tr>
<%} //while end!

pstmt.close();
conn.close();
}catch(Exception e){}
finally{}
%>
</table>
</div>
</body>
</html>