<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Ph_print_search</title>
</head>
<body>
<div class="container">
  <h2><button class="btn" onclick="location.href='Ph_index.jsp'"><i class="fa fa-home"></i></button>개별 연락처 찾기</h2> 
  <form action=Ph_print_search_proc.jsp method=post>
 
     <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
    </div>
  
    <button type="submit" class="btn btn-default">찾기</button>
  </form>
  
</div> 
 
</body>
</html>