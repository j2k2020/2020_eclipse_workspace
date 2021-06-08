<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update_proc</title>
</head>
<body>
<%
try{
	int no=Integer.parseInt(request.getParameter("no"));
	String name=request.getParameter("name");
	String content=request.getParameter("content");
	//정상적으로 진행되는 컴파일 창에서 확인 
	System.out.println("no:"+no);
	System.out.println("name:"+name);
	System.out.println("content:"+content);
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
	//url,id,password
	if(conn==null) {System.out.println("DB접속에 실패");}
	System.out.println("DB접속 성공");
	
	
	String sql="update message set name=?,content=? where no=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,name);
	pstmt.setString(2,content);
	pstmt.setInt(3,no);
	int result=pstmt.executeUpdate();//qurey는 요청, update는 변경
	System.out.println(result+"개가 수정되었습니다.");
	
	
	pstmt.close();
	conn.close();
	
	response.sendRedirect("list.jsp");
	
}catch(Exception e){}
finally{}
%>
</body>
</html>