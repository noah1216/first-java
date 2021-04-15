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
  <% 
	List<questionsBean> questionList = (List<questionsBean>)request.getAttribute("list");
    String questionID = (String)request.getAttribute("questionID");
    System.out.println(questionID);
	int i = Integer.parseInt(questionID); 
	System.out.println(i);
    /* questionsBean question = questionList.get(i);  */
%>
  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="questionーbox">
          <label class="valign">問題:</label>
          <textarea class="text-size text-size-h250" rows="10" cols="60"></textarea>
          <p>
            <label>答え:</label>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
          <p>
            <input type="text" name="example" value="選択肢" class="text-size">
          </p>
        </div>
      </div>
      <div class="center">
        <input type="button" value="編集" >
        <input type="button" value="削除" >
      </div>
    </div>
  </div>
</main>
</body>
</html>