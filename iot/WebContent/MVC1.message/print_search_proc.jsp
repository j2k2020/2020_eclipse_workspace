<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%
		String name=null;
		String content=null;
		int no=0;
		
		try{
		no=Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		
		if(conn==null) {System.out.println("DB접속에 실패");}
		System.out.println("DB접속 성공");
		
		//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
				
		String sql="select * from message where no=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		pstmt.setInt(1, no);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {	
			name=rs.getString("name");
			content=rs.getString("content");	
		}
		pstmt.close();
		conn.close();
		}//try end
		catch(Exception e){}
		finally{}
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>Message Print</title>
</head>
<body>


<div class="container">
  <h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>검색 결과</h2>
     
    <div class="form-group">
      <label for="no">번호:</label>
      <input value=<%=no%> disabled type="text" class="form-control" id="no" name="no" >
    </div>
    
    <div class="form-group">
      <label for="name">이름:</label>
      <input value=<%=name%> disabled type="text" class="form-control" id="name" name="name">
    </div>
    
    <div class="form-group">
      <label for="content">메모:</label>
      <input value=<%=content%> disabled  type="text" class="form-control" id="content" name="content">
    </div>
    
    <div class="form-group">
	<button onclick="location.href='update_search_view.jsp?no=<%=no%>'">수정</button>
	<button onclick="location.href='delete_proc.jsp?no=<%=no%>'">삭제</button>
    </div>
 
</div>
</body>
</html>