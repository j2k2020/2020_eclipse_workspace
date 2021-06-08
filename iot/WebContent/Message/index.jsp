<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Message Menu //Bootstrap 4 List Groups</title>
</head>
<body>

<div class="container">
 <h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>Message관리</h2>
  <p>메뉴를 선택하세요~</p>
  <div class="list-group">
    <a href="Message_form.jsp" class="list-group-item list-group-item-action list-group-item-active">메시지 입력 </a>
    <a href="list.jsp" class="list-group-item list-group-item-action list-group-item-primary">메시지(전체 리스트) 출력 </a>
    <a href="print_search.jsp" class="list-group-item list-group-item-action list-group-item-info">메시지 개별 출력 </a>
    <a href="update_search.jsp" class="list-group-item list-group-item-action list-group-item-warning">메시지 수정 </a>
    <a href="delete_search.jsp" class="list-group-item list-group-item-action list-group-item-danger">메시지 삭제 </a>
   
  </div>
</div>

</body>
</html>