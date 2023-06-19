<%--
JavaWebSession Lesson Src06

ユーザー情報確認画面。

ファイル名=inputUserConfirm.jsp
ディレクトリ=?javawebsession/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="local.hal.night.javawebsession.*"%>
<%
	User user = (User) session.getAttribute("userInfo");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>ユーザー情報確認画面</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
	<h1>ユーザー情報確認画面</h1>
	<nav id="breadcrumbs">
		<ul>
			<li><a href="/javawebsession/inputUserInfo1.jsp">入力１</a></li>
			<li><a href="/javawebsession/inputUserInfo2.jsp">入力2></a></li>
			<li class="current">確認</li>
			<li>完了</li>
		</ul>
	</nav>
	<section>
		<p>以下の情報で登録を行います。よろしければ、登録ボタンをクリックしてください。</p>
		<dl>
			<dt>ログインID</dt>
			<dd><%=user.getLogin()%></dd>
			<dt>パスワード</dt>
			<dd>******(セキュリティのため表示していません)</dd>
			<dt>氏名</dt>
			<dd><%=user.getNameLast()%>&nbsp;<%=user.getNameFirst()%></dd>
			<dt>メール</dt>
			<dd><%=user.getMail()%></dd>
		</dl>
		<form action="/javawebsession/add" method="post">
			<button type="submit">登録</button>
		</form>
	</section>
</body>
</html>