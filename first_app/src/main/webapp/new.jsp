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
          <a href="top.jsp">
	        <button type="button" class="b-size magin-l10">top</button>
	      <a href="logoutServlet">
	        <button type="button" class="b-size magin-l10">logout</button>
	      </a>
  </div>

<form action="newServlet">
  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <label class="valign">問題:</label>
          <textarea class="text-size text-size-h250" rows="10" cols="60" name="question">ここに記入してください</textarea>
          <p>
            <label>答え:</label>
            <input type="text" name="answer" value="選択肢" class="text-size84">
            <input type="button" value="削除" >
          </p>
        </div>
      </div>
      <div class="center">
        <input type="submit" value="確認" >
         <a href="listServlet">
	        <button type="button" >戻る</button>
	      </a>
         <a href="listServlet">
	        <button type="button" >追加</button>
	     </a>
      </div>
    </div>
  </div>
</form>
</main>
</body>
</html>