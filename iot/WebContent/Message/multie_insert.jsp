<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>m</title>
</head>
<body>
<%
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
//url,id,password
if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


PreparedStatement pstmt=null;
for(int i=0; i<10; i++){ //만들고 싶은  갯수
	//String sql="insert into message(no,name,content) values("+(i+9)+",'hong','hong message')";
	String sql="insert into message(no,name,content) values(message_seq_no.nextval";
	//sql+=i+9;
	sql+=",'hong','hong message')";
	pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
	int result=pstmt.executeUpdate();
}

pstmt.close();
conn.close();

response.sendRedirect("list.jsp");


}catch(Exception e){}
finally{}



%>
</body>
</html>