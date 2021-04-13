<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/main.css" >
<title>タイトル</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body>
<main>
<% String errorMassage = (String)request.getAttribute("error_message"); %>
<form action="loginServlet" method="post">
<% if (errorMassage != null) { %>
<%= errorMassage %>
<% } %> 
  <div class="login-center">
    <div class="login-box">
      <h2>login</h2>
      <div class="login-form"> 
        ID: <input type="text" name="id" size="30" maxlength="20">
      </div>
      <div class="login-form">
        pw: <input type="text" name="password" size="30" maxlength="20">
      </div>
      <div class="login-form">
        <input type="submit" value="login">
       </div>
    </div>
  </div>
  </form>
</main>
</body>
</html>