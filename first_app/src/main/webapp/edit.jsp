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
<form action="editConfirmServlet">
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
          <textarea class="text-size text-size-h250" rows="10" cols="60" name="question" ><%=request.getAttribute("question")%></textarea>
          <p>
            <label>答え:</label>
            <input type="text" name="answer" value="<%= request.getAttribute("answer") %>" class="text-size84">
            <input type="button" value="削除" >
          </p>
        </div>
      </div>
      <div class="center">
        <a href="listServlet">
	      <button type="button">戻る</button>
	    </a>
        <input type="submit" value="確認" >
        <input type="button" value="追加" >
        <input type="hidden" name="answerId" value="<%= request.getAttribute("answerId") %>">
        <input type="hidden" name="questionId" value="<%= request.getAttribute("questionId") %>"> 
      </div>
    </div>
  </div>
  </form>
</main>
</body>
</html>