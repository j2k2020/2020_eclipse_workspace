<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
    <%@page isErrorPage="true" %>
    
    <%
try{
String name=request.getParameter("name");
String PHnum=request.getParameter("PHnum");
String memo=request.getParameter("memo");

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");

String sql="insert into phonebook(no,name,PHnum,memo) values(phonebook_seq_no.nextval,?,?,?)";
PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
pstmt.setString(1,name);
pstmt.setString(2,PHnum);
pstmt.setString(3,memo);

int result=pstmt.executeUpdate();
System.out.println(result+"개가 입력되었습니다.");

pstmt.close();
conn.close();

response.sendRedirect("Ph_list.jsp");
}catch(Exception e){}
finally{}
%>
