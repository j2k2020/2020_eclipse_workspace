<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
    <%
try{
	int no=Integer.parseInt(request.getParameter("no"));
	String name=request.getParameter("name");
	String PHnum=request.getParameter("PHnum");
	String memo=request.getParameter("memo");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
	if(conn==null) {System.out.println("DB접속에 실패");}
	System.out.println("DB접속 성공");
		
	String sql="update phonebook set name=?,PHnum=?,memo=? where no=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,name);
	pstmt.setString(2,PHnum);
	pstmt.setString(3,memo);
	pstmt.setInt(4,no);
	int result=pstmt.executeUpdate();//qurey는 요청, update는 변경
	System.out.println(result+"개가 수정되었습니다.");
	
	pstmt.close();
	conn.close();
	
	response.sendRedirect("Ph_list.jsp");
	
}catch(Exception e){}
finally{}
%>
