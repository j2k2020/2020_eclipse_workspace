<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<% 
int no=0;
String name=null;
String PHnum=null;
String memo=null;

try{
	
	no=Integer.parseInt(request.getParameter("no"));
	System.out.println(no);
	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

if(conn==null) {System.out.println("DB접속에 실패");}
System.out.println("DB접속 성공");


String sql="Select*from phonebook where no=?"; //이름으로 검색
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setInt(1, no); //조건채워주기
ResultSet rs=pstmt.executeQuery();

if(rs.next()) {
	name=rs.getString("name");
	PHnum=rs.getString("PHnum");
	memo=rs.getString("memo");
}
    pstmt.close();
    conn.close();
}catch(Exception e){}
finally{}
%>
   
<!DOCTYPE html>
<html>
<head>
<script>
function dataCheck(){
	if(document.getElementById("name").value==""){
		alert("이름을 입력해 주세요")
		return;
	}
	if(document.getElementById("PHnum").value==""){
		alert("연락처를 입력해 주세요")
		return;
	}
	if(document.getElementById("memo").value==""){
		alert("메시지를 입력해 주세요")
		return;
	}
	
	document.form.submit();
	
}
</script>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Ph_Update_search_view</title>
</head>
<body>

<div class="container">
  <h2>수정하기 <button class="btn" onclick="location.href='Ph_index.jsp'"><i class="fa fa-home"></i></button> </h2> 
 
  <form name=form action=Ph_update_proc.jsp method=post>
  
    <div class="form-group">
      <label for="no">번호:</label>
      <input value=<%=no %> disabled type="text" class="form-control"> <!-- disabled때문에 정보가 전송되지 않음 -->
      <input value=<%=no %> type="hidden" id="no" name="no" > <!-- 화면에는 보이지 않으나, id,name값을 받아서 다음 페이지로 넘긴다. -->
    </div>
    
    <div class="form-group">
      <label for="name">이름:</label>
      <input value=<%=name %>  type="text" class="form-control" id="name" name="name" >
    </div>
    
    <div class="form-group">
      <label for="PHnum">전화번호:</label>
      <input value=<%=PHnum %>  type="text" class="form-control" id="PHnum" name="PHnum" >
    </div>
    
    <div class="form-group">
      <label for="memo">메모:</label>
      <input value=<%=memo %>  type="text" class="form-control" id="memo" name="memo" >
    </div>


    <button type="button" onclick=dataCheck() class="btn btn-default">수정</button>
  </form>
  </div>
  




</body>
</html>