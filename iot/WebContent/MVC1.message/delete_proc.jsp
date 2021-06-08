<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>

<%
try{
	//request.setCharacterEncoding("utf-8");
int no=Integer.parseInt(request.getParameter("no")); 
System.out.printf("%d\n",no);

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
//url,id,password

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");

String sql="delete from message where no=?";
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setInt(1, no);
int result=pstmt.executeUpdate();
System.out.println(result+"개가 삭제되었습니다.");

pstmt.close();
conn.close();

response.sendRedirect("list.jsp");

}catch (Exception e){}
finally{}

%>