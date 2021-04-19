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
  <div class="header-box">

          <form action="testCreateServlet" method="post">
	        <button type="submit" class="b-size magin-l10">top</button>
	        <input type="hidden" name="user_id" value="<%= request.getAttribute("user_id") %>"> 
	        <input type="hidden" name="point" value="<%= request.getAttribute("total") %>"> 
	      </form>
	      <a href="logoutServlet">
	        <button type="button" class="b-size magin-l10">logout</button>
	      </a>
  </div>
  <h2 class="title1">テスト結果</h2>
  <div class="test-box">
    <ul class="test-user">
      <li>
        <%=request.getAttribute("user_name")%>さん
      </li>
      <li>
        <%=request.getAttribute("questions") %>問中<%=request.getAttribute("count") %>問正解です。
      </li>
      <li>
        <%=request.getAttribute("total") %>点でした。
      </li>
    </ul>
    <div class="test-day">
      <p>
        <%=request.getAttribute("data") %>
      </p>
    </div>
  </div>
</main>
</body>
</html>