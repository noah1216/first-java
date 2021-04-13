<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Bean.questionsBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="style.css">
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
	      </a>
	      <a href="logoutServlet">
	        <button type="button" class="b-size magin-l10">logout</button>
	      </a>
  </div>
  <div class="list-center">
    <a href="registerServlet">
	  <button type="button" class="b-size">新規登録</button>
	</a>
  </div>

  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <p>
            <label>問題:</label>
            <label>1</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <label>答え1:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <label>答え2:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
        </div>

        <div>
          <input type="button" value="編集" >
          <input type="button" value="削除" >
        </div>
      </div>
    </div>
  </div>

  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <p>
            <label>問題:</label>
            <label>1</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <label>答え1:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <label>答え2:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
        </div>

        <div>
          <input type="button" value="編集" >
          <input type="button" value="削除" >
        </div>
      </div>
    </div>
  </div>

 <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <p>
            <label>問題:</label>
            <label>1</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <label>答え1:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <label>答え2:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
        </div>

        <div>
          <input type="button" value="編集" >
          <input type="button" value="削除" >
        </div>
      </div>
    </div>
    <%
    
List<questionsBean> questionList = (List<questionsBean>)request.getAttribute("list");
for (int i =0; i < questionList.size(); i++) {
    questionsBean question = questionList.get(i);
    if (question == null) {
        continue;
    }
%>
<input type="text" name="id" value="<%= question.getId() %>"><br />
<input type="text" name="question" value="<%= question.getQuestion() %>">
<% } %>
  </div>


 
</main>
</body>
</html>