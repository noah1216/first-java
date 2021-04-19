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
<form action="editConfirmServlet" method="post">
  <div class="header-box">
    <input type="submit" value="top" class="b-size magin-l10">
    <input type="submit" value="logout" class="b-size magin-l10">
  </div>

  <div class="edit-numder">
    <label>問題番号:</label>
    <label class="number" ><%= request.getAttribute("questionId") %></label>
  </div>

  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <label class="valign">問題:</label>
          <textarea class="text-size text-size-h250" rows="10" cols="60" name="question" readonly><%= request.getAttribute("question") %></textarea>
          <p>
            <label>答え:</label>
            <input type="text" name="answer" value="<%= request.getAttribute("answer") %>" class="text-size" readonly>
          </p>
        </div>
      </div>
      <div class="center">
        <input type="button" value="戻る">
        <input type="submit" value="更新">
        <input type="hidden" name="questionId" value="<%= request.getAttribute("questionId") %>"> 
      </div>
    </div>
  </div>
  </form>
</main>
</body>
</html>