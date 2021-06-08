<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.iot.web.ConnectionPool" %>
<%@ page import="PhoneBook.Phonebook" %>
<%@ page import="java.util.ArrayList, java.util.List" %>

<% 
Connection conn;
String sql;
PreparedStatement pstmt;
ResultSet rs;

String _requestPage;
int requestPage=1;
//전체 글의 갯수 ******
int totalCount=0;
//페이지당 글의 갯수 ********
int countPerPage=10;
int firstRow;
int endRow;
int startPage=1;
int endPage=1;
int totalPageCount=0;

List<Phonebook> list=new ArrayList<Phonebook>();

String field=request.getParameter("field");
String search=request.getParameter("search");
if(field==null||search==null){
	
}
System.out.printf("%s %s\n",field,search);


try{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");

   if(conn==null) {System.out.println("DB접속에 실패");}
   System.out.println("DB접속 성공");

 //1.요청한 페이지번호
 		_requestPage=request.getParameter("requestPage");
 		if(_requestPage!=null)
		{requestPage=Integer.parseInt(_requestPage);}
		System.out.printf("requestPage:%d\n", requestPage);
 
		field=request.getParameter("field");
		search=request.getParameter("search");
		if(field==null || search==null){
			
		}
		System.out.printf("%s, %s\n",field, search);
		
		
//2.전체 페이지 수 구하기
        sql="select * from phonebook where ";
		sql+=field;
		sql+=" like '%";
		sql+=search;
		sql+="%'"; //where 필드명 like
		
		pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		rs=pstmt.executeQuery();
		
		while(rs.next()) totalCount++;

//전체페이지 수를 구해야 
		//요청한 페이지의 시작 글번호와 끝 글번호가 나오기 때문
		firstRow=(requestPage-1)*countPerPage+1; 
		if(firstRow<1){firstRow=0;}

		endRow=firstRow+countPerPage-1;
		if(endRow>totalCount){
			endRow=totalCount;
		}
				
		//전체페이지수******
		
		if(totalCount%10==0){
		totalPageCount=(totalCount/countPerPage);
		}else{
			totalPageCount=(totalCount/countPerPage)+1;
		}
		//시작페이지 구하기
		if(startPage<1){startPage=1;}
		//끝페이지 구하기
		//int endPage=startPage+4;
		
		if((startPage+4)>totalPageCount){
			endPage=totalPageCount;
		}else{
			endPage=startPage+4;
		}
		if(endPage>totalPageCount){ endPage=totalPageCount; }
		
		//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기 
		sql="select rownum,no,name,PHnum,memo from ";
		sql+="(select * from phonebook where ";
		sql+=field;
		sql+=" like '%";
		sql+=search;
		sql+="%') ";
		sql+="where rownum>=? and rownum<=? order by rownum desc"; 
		
		pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		pstmt.setInt(1, totalCount-endRow); //desc
		pstmt.setInt(2, totalCount-firstRow ); //desc
		rs=pstmt.executeQuery();
		
		
		while(rs.next()) {
			Phonebook pb=new Phonebook();
			pb.setNo(rs.getInt("no"));
			pb.setName(rs.getString("name"));
			pb.setPHnum(rs.getString("PHnum"));
			pb.setMemo(rs.getString("memo"));
			list.add(pb);
		}
		rs.close();
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
	if(document.getElementById("search").value==""){
		alert("검색 내용을 입력해 주세요")
		document.getElementById("search").focus();
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
<title>Ph_list</title>
</head>

<body>
<div class="container">
 <h2><button class="btn" onclick="location.href='Ph_index.jsp'"><i class="fa fa-home"></i></button>연락처 전체 리스트</h2>
<form name=form action="Ph_list_search.jsp" method=post>
<div class="form-group">
<select name=field>
 	<option value=name>이름</option>
 	<option value=PHnum>연락처</option>
 	<option value=memo>메시지</option>
 </select>
 	
<input type="text" name="search" placeholder="찾을 내용을 입력하세요">
<button type="button" onclick=dataCheck()  class="btn btn-default">검색</button>
</div>
</form>
<table class="table">

<tr class="danger" class="table-hover">
<th>※번호※</th><th>※이름※</th><th>※연락처※</th><th>※메모※</th>
</tr>

<%//반복문 시작 %>
<% for(int i=0;i<list.size();i++){ 
	Phonebook pb=list.get(i);
%>
<tr onmouseover="this.style.backgroundColor='lightgray'" 
	onmouseout="this.style.backgroundColor='white'"
onclick="location.href='Ph_print_search_proc.jsp?no=<%=pb.getNo()%>'">
<td><%=pb.getNo()%></td>
<td ><%=pb.getName()%></td>
<td><%=pb.getPHnum()%></td>
<td><%=pb.getMemo()%></td>
</tr>
<%} %>
<%//반복문 끝 %>

<tr>
<td colspan=2 align=center valign="center">
<ul class="pagination">
    <% if(requestPage!=1){ %>
    <li class="page-item"><a class="page-link" href="Ph_list.jsp?requestPage=<%=requestPage-1%>">이전페이지</a></li>
    <%}%>
    <% for(int i=startPage;i<=endPage;i++){ %>
    <li class="page-item"><a class="page-link" href="Ph_list.jsp?requestPage=<%=i%>"><%=i%></a></li>
    <% } %>
    <% if(totalPageCount!=requestPage){ %>
    <li class="page-item"><a class="page-link" href="Ph_list.jsp?requestPage=<%=requestPage+1%>">다음페이지</a></li>
    <%} %>
  </ul>
</td>
<td>
<button onclick="location.href='Ph_Form.jsp'">글쓰기</button>
</td>
</tr>
</table>