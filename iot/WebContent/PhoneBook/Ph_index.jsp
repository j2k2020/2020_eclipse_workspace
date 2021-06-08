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
<title>Ph_index</title>
</head>
<body>

<div class="container">
 <h2><button class="btn" onclick="location.href='Ph_index.jsp'"><i class="fa fa-home"></i></button>☎My PhoneBook 관리☎</h2>
  <p>메뉴를 선택하세요~</p>
  <div class="list-group">
    <a href="Ph_Form.jsp" class="list-group-item list-group-item-action list-group-item-active">연락처 입력 </a>
    <a href="Ph_list.jsp" class="list-group-item list-group-item-action list-group-item-primary">전체 연락처 리스트 출력 </a>
    <a href="Ph_print_search.jsp" class="list-group-item list-group-item-action list-group-item-info">개별 연락처 출력 </a>
    <a href="Ph_update_search.jsp" class="list-group-item list-group-item-action list-group-item-warning">연락처 수정 </a>
    <a href="Ph_delete_search.jsp" class="list-group-item list-group-item-action list-group-item-danger">연락처 삭제 </a>
   
  </div>
</div>

</body>
</html>