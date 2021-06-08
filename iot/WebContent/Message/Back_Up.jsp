<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message List</title>
</head>
<body>
<table border=1 width=50%>
<tr>
<th>번호</th><th>이름</th><th>메시지</th>
</tr>
<% 
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


String sql="Select*from message"; //전체 사용
PreparedStatement pstmt=conn.prepareStatement(sql);
ResultSet rs=pstmt.executeQuery();

while(rs.next()) {

%>
<tr>
<td><%=rs.getInt("no") %></td><td><%=rs.getString("name") %></td><td><%=rs.getString("content") %></td>
</tr>
<%} //while end!

pstmt.close();
conn.close();
}catch(Exception e){}
finally{}
%>

</table>

</body>
</html>