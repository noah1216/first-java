<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="style.css">
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

  <div class="button-box">
    <div class="buttonsize-box">
      <div class="tyuou">
        <div class="question-box">
          <label class="valign">問題:</label>
          <textarea class="text-size text-size-h250" rows="10" cols="60">ここに記入してください</textarea>
          <p>
            <label>答え:</label>
            <input type="text" name="example" value="選択肢" class="text-size84">
            <input type="button" value="削除" >
          </p>
          <p>
            <input type="text" name="example" value="選択肢" class="text-size84">
            <input type="button" value="削除" >
          </p>
        </div>
      </div>
      <div class="center">
        <input type="button" value="確認" >
        <input type="button" value="戻る" >
        <input type="button" value="追加" >
      </div>
    </div>
  </div>
</main>
</body>
</html>