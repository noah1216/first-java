<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Bean.questionsBean"%>
<%@ page import="Bean.answersBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>タイトル</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
</head>
<body>
<main>
  <div class="header-box">
    <input type="submit" value="top" class="b-size magin-l10">
    <input type="submit" value="logout" class="b-size magin-l10">
  </div>
<%--   <% 
	List<questionsBean> questionList = (List<questionsBean>)request.getAttribute("list");
    String questionID = (String)request.getAttribute("questionID");
    System.out.println(questionID);
	int i = Integer.parseInt(questionID) - 1; 
    questionsBean question = questionList.get(i); 
    System.out.println(question);
%> --%>
  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="questionーbox">
          <label class="valign">問題:</label>
          <textarea name="question" class="text-size text-size-h250" rows="10" cols="60"><%=request.getAttribute("question")%></textarea>
          <p>
            <label>答え:</label>
            <input type="text" name="answer" value="<%= request.getAttribute("answer") %>" class="text-size">
          </p>
        </div>
      </div>
      <form action="deleteSarvlet" method="post">
      <div class="center">
        <input type="hidden" name="questionId" value="<%= request.getAttribute("questionId") %>"> 
          <a href="listServlet.jsp">
	        <button type="button">戻る</button>
	      </a>
        <input type="submit" value="削除" >
      </div>
      </form>
    </div>
  </div>
</main>
</body>
</html>