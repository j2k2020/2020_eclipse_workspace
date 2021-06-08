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
<title>Ph_list_search</title>
</head>
<body>
<div class="container">
 <h2><button class="btn" onclick="location.href='Ph_index.jsp'"><i class="fa fa-home"></i></button>연락처 전체 리스트</h2>
<table class="table">

<tr class="danger" class="table-hover">
<th>※번호※</th><th>※이름※</th><th>※전화번호※</th><th>※메모※</th>
</tr>
<% 

try{
	String name=request.getParameter("name"); // name을 받아오기
	System.out.println(name);
	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


String sql="Select*from phonebook where name=?"; //전체 사용 asc/desc
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1, name); //조건채워주기
ResultSet rs=pstmt.executeQuery();

if(rs.next()) {

%>
<tr class="success">
<td><%=rs.getInt("no") %></td><td><%=rs.getString("name") %></td><td><%=rs.getString("PHnum") %></td><td><%=rs.getString("memo") %></td>
</tr>
 <%} else{%>
<script>
alert("검색한 결과가 없습니다.");
window.location.href='http://localhost:9090/PhoneBook/Ph_list.jsp'
</script>
<% 
}

      pstmt.close();
      conn.close();

}catch(Exception e){}
finally{}
%>

</body>
</html>