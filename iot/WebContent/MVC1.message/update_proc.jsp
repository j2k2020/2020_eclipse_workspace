<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%
try{
	//request.setCharacterEncoding("utf-8");
int no=Integer.parseInt(request.getParameter("no")); 
String name=request.getParameter("name");
String content=request.getParameter("content");
System.out.printf("%d,%s,%s\n",no,name,content);

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
//url,id,password

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");

String sql="update message set name=?,content=? where no=?";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1,name);
pstmt.setString(2,content);
pstmt.setInt(3,no);
int result=pstmt.executeUpdate();
System.out.println(result+"개가 수정되었습니다.");

pstmt.close();
conn.close();

response.sendRedirect("list.jsp");

}catch (Exception e){}
finally{}

%>