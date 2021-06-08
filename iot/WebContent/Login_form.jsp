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
<title>Login_form</title>
</head>
<body>
<!-- 
<form action=login.jsp method=post>
아이디 : <input type=text name=id><p>
패스워드: <input type=password name=password><p>
<input type=submit value="로그인"><p>
</form>
 -->
 <div class="container">
  <h2>로그인</h2>
  <form action=Login.jsp method=post>
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요">
    </div>
    <div class="form-group">
      <label for="pwd">패스워드:</label>
      <input type="password" class="form-control" id="pwd" name="password" placeholder="패스워드를 입력하세요">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remeber">아이디/패스워드 저장</label>
    </div>
    <button type="submit" class="btn btn-default">로그인</button>
  </form>
</div>
</body>
</html>