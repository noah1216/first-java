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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
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
		<form action="testServlet"  method="post">
		<div class="button-box">
			<div class="buttonsize-box">
				<div class="tyuou">
					<div class="question-box">
						<% 
						List<questionsBean> questionList = (List<questionsBean>)request.getAttribute("list");
						if (questionList != null) {
						for (int i =0; i < questionList.size(); i++) {
						    questionsBean question = questionList.get(i);
						    if (question == null) {
						        continue;    		
						    }
						%>
						<label class="valign"><%= i + 1 %> </label>
						<textarea class="text-size text-size-h170" rows="10" cols="60"
							readonly><%= question.getQuestion() %></textarea>
						<p>
							<label>回答 </label>
							 <input type="text" name="answer" value="選択肢" class="text-size maginbottom">
						</p>
						<% }} %>
					</div>
				</div>
				<div class="center">
					<input type="hidden" name="user_name"  value="<%= request.getAttribute("user_name") %>" >
					<input type="hidden" name="user_id"  value="<%= request.getAttribute("user_id") %>" >
					<input type="submit" value="採点">
				</div>
			</div>
		</div>
		</form>
	</main>
</body>
</html>