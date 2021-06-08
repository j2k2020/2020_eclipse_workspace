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
<title>Message Print</title>
</head>
<body>

<% 
try{
	String name=request.getParameter("name"); // name을 받아오기
	System.out.println(name);
	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


String sql="Select*from message where name=?"; //이름으로 검색
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1, name); //조건채워주기
ResultSet rs=pstmt.executeQuery();

if(rs.next()) {
%>
<div class="container">
  <h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>검색 결과 </h2> 
 
    <div class="form-group">
      <label for="no">번호:</label>
      <input value=<%=rs.getInt("no") %> disabled type="text" class="form-control" id="no" name="no" >
    </div>
    
    <div class="form-group">
      <label for="name">이름:</label>
      <input value=<%=rs.getString("name") %> disabled type="text" class="form-control" id="name" name="name" >
    </div>
    
    <div class="form-group">
      <label for="content">메모:</label>
      <input value=<%=rs.getString("content") %> disabled type="text" class="form-control" id="content" name="content" >
    </div>
    
    <div class="form-group">
      <button onclick="location.href='update_search_view.jsp?no=<%=rs.getInt("no") %>'" >글수정</button>
      <button onclick="location.href='delete_search_view.jsp?no=<%=rs.getInt("no") %>'" >글삭제</button>
    </div>
   
 <%} else{%>
<script>
alert("검색한 결과가 없습니다.");
window.location.href='http://localhost:9090/message/print_search.jsp'
</script>
<%
//response.sendRedirect("print_search.jsp");	 
}

      pstmt.close();
      conn.close();

}catch(Exception e){}
finally{}
%>

</div>
</body>
</html>