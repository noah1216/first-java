<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@include file="../css/main.css" %> --%>
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
 <form action="logoutServlet" method="get">
  <div class="header-box">
    <div>
      <input type="submit" value="logout">
    </div>
  </div>
 </form>
  <div class="button-box">
    <div class="buttonsize-box">
      <div class="top-center">
        <a href="listServlet">
	        <button type="button" class="button-size1">問題と答えを確認・登録する　＞</button>
	      </a>
      </div>   

      <div class="top-center">   
	      <form action="testServlet">	  
	  <% String name = (String)session.getAttribute("login_name"); %>
      <% int user_id = (int)session.getAttribute("login_id"); %>
	       <input type="hidden" name="user_name" value="<%= name %>">
	       <input type="hidden" name="user_id" value="<%= user_id %>">
		        <button type="submit" class="button-size1">テストをする　＞</button>
		  </form>
	  </div>
      <div class="top-center">
	      <form action="historyServlet">
	       <input type="hidden" name="user_name" value="<%= name %>">
	       <input type="hidden" name="user_id" value="<%= user_id %>">
		   <button type="submit" class="button-size1">過去の採点結果を見る　＞</button>
		   </form>
      </div>
    </div>
  </div>
</main>
</body>
</html>