<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>delete_search</title>
</head>
<body>
<div class="container">
  <h2><button class="btn" onclick="location.href='index.jsp'"><i class="fa fa-home"></i></button>개별 삭제 찾기 </h2> 
 <form action=delete_search_view.jsp method=post>
  <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
    </div>
  
    <button type="submit" class="btn btn-default">찾기</button>
  </form>
  
</div> 
 
</body>
</html>