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
<title>Message Delete</title>
</head>
<body>

<% 
try{
	//String name=request.getParameter("name"); // name을 받아오기
	//System.out.println(name);	
	int no=Integer.parseInt(request.getParameter("no")); // no을 받아오기
	System.out.println(no);
	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


//String sql="Select*from message where name=?"; //이름으로 검색
String sql="Select*from message where no=?";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setInt(1, no); //조건채워주기
ResultSet rs=pstmt.executeQuery();

if(rs.next()) {
%>
<div class="container">
  <h2>삭제하기 </h2> 
  <form action=delete_proc.jsp method=post>
    <div class="form-group">
      <label for="no">번호:</label>
      <input value=<%=rs.getInt("no") %> disabled type="text" class="form-control"> <!-- disabled때문에 정보가 전송되지 않음 -->
      <input value=<%=rs.getInt("no") %> type="hidden" id="no" name="no" > <!-- 화면에는 보이지 않으나, id,name값을 받아서 다음 페이지로 넘긴다. -->
    </div>
  
    <div class="form-group">
      <label for="name">이름:</label>
      <input value=<%=rs.getString("name") %> disabled type="text" class="form-control" id="name" name="name" >
    </div>
    
    <div class="form-group">
      <label for="content">메모:</label>
      <input value=<%=rs.getString("content") %> disabled type="text" class="form-control" id="content" name="content" >
    </div>


 <button type="submit" class="btn btn-default">삭제</button>
  </form> 
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

</body>
</html>