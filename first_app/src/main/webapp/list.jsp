<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Bean.questionsBean"%>
<%@ page import="Bean.answersBean"%>
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

  <% 
List<questionsBean> questionList = (List<questionsBean>)request.getAttribute("list");
for (int i =0; i < questionList.size(); i++) {
    questionsBean question = questionList.get(i);
    if (question == null) {
        continue;    		
    }
%>
<form action="deleteSarvlet">
 <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <p>
            <label>問題:</label>
            <label><%= question.getId() %></label>
            <input type="text" name="question" class="text-size" value="<%= question.getQuestion() %>">
          </p>
           <% 
			List<answersBean> answerList = (List<answersBean>)request.getAttribute("list2");
			for (int c =0; c < answerList.size(); c++) {
				answersBean answer = answerList.get(c);
				int id1 = question.getId();
				int id2 = answer.getQuestionsId();
			    if (id1 != id2) {
			        continue;
			    }
			%>
          <p>
            <label>答え1:</label>
            <input type="text" name="answer" value="<%= answer.getAnswer() %>" class="text-size">
          </p>
          <% } %>
        <div>
           <input type="hidden" name="questionId" value="<%= question.getId() %>"> 
	       <button type="submit">削除</button>
          <a href="deleteSarvlet">
	        <button type="button">編集</button>
	      </a>
        </div>
      </div>
    </div>
  </div>
  </form>
<% } %>


 
</main>
</body>
</html>