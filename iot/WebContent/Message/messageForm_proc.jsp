<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>messageForm_proc</title>
</head>
<body>
<%
try{
//int no=Integer.parseInt(request.getParameter("no"));
String name=request.getParameter("name");
String content=request.getParameter("content");
//정상적으로 진행되는 컴파일 창에서 확인 
//System.out.println("no:"+no);
System.out.println("name:"+name);
System.out.println("content:"+content);


Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
//url,id,password
if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


//String sql="insert into message(no,name,content) values(?,?,?)";
String sql="insert into message(no,name,content) values(message_seq_no.nextval,?,?)";
PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
//(?)물음표를 채워줘야함
/*
pstmt.setInt(1,no);
pstmt.setString(2,name);
pstmt.setString(3,content);
*/
pstmt.setString(1,name);
pstmt.setString(2,content);
int result=pstmt.executeUpdate();
System.out.println(result+"개가 입력되었습니다.");


pstmt.close();
conn.close();

response.sendRedirect("list.jsp");


}catch(Exception e){}
finally{}



%>
</body>
</html>