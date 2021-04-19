<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Bean.historiesBean"%>
<%@ page import="java.util.List"%>
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
    <div>
          <a href="top.jsp">
	        <button type="button" class="b-size magin-l10">top</button>
	      </a>
	      <a href="logoutServlet">
	        <button type="button" class="b-size magin-l10">logout</button>
	      </a>
    </div>
  </div>
  <div class="button-box">
    <div class="buttonsize-box text_box1">
      <h2>履歴</h2>
      <div class="table">
        <table border="1" width="500">
          <tr>
            <th>名前</th>
            <th>得点</th>
            <th>採点時間</th>
          </tr>
          <% 
			List<historiesBean> historyList = (List<historiesBean>)request.getAttribute("list3");
			if (historyList != null) {
			for (int i =0; i <  historyList.size(); i++) {
				historiesBean history =  historyList.get(i);
			    if (history == null) {
			        continue;    		
			    }
			%>
          <tr>
            <th><%= request.getAttribute("user_name") %></th>
            <th><%= history.getPoint() %></th>
            <th><%= history.getCreatedAt() %></th>
          </tr>
          <%}} %>
        </table>
      </div>
    </div>
  </div>
</main>
</body>
</html>