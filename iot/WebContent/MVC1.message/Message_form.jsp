<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<script>
function dataCheck(){
	if(document.getElementById("name").value==""){
		alert("이름을 입력해 주세요")
		return;
	}
	if(document.getElementById("content").value==""){
		alert("메시지를 입력해 주세요")
		return;
	}
	document.form.submit();	
}
</script>
</head>
<body>
<div class="container">
  <h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>메시지 입력</h2>
  <form name=form action="messageForm_proc.jsp" method=post>
    
    <div class="form-group">
      <label for="no">번호:</label>
      <input disabled type="text" class="form-control" id="no" name="no" placeholder="번호를 입력 하세요">
    </div>
    
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력 하세요">
    </div>
    
    <div class="form-group">
      <label for="content">메모:</label>
      <input type="text" class="form-control" id="content" name="content" placeholder="메모를 입력 하세요">
    </div>
    
    <button type="button" onclick=dataCheck() class="btn btn-default">입력</button>
  </form>
</div>
</body>
</html>