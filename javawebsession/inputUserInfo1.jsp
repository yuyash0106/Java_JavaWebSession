<%--
JavaWebSession Lesson Src02

ユーザー情報入力画面１。

ファイル名=inputUserInfo1.jsp
ディレクトリ=/javawebsession/
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="local.hal.night.javawebsession.*"%>
<%
	User user = (User) session.getAttribute("userInfo");
	if (user == null) {
		user = new User();
	}
	List<String> validationMsgs = (List<String>) request.getAttribute("validationMsgs");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>ユーザー情報入力画面１</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
	<h1>ユーザー情報入力画面1</h1>
	<nav id="breadcrumbs">
		<ul>
			<li class="current">入力１</li>
			<li>入力２</li>
			<li>確認</li>
			<li>完了</li>
		</ul>
	</nav>
	<%
		if (validationMsgs != null) {
	%>
	<section id="errorMsg">
		<p>以下のメッセージをご確認ください。</p>
		<ul>
			<%
				for (String msg : validationMsgs) {
			%>
			<li><%=msg%></li>
			<%
				}
			%>
		</ul>
	</section>
	<%
		}
	%>
	<section>
		<p>情報を入力し、次へボタンをクリックしてください。</p>
		<form action="/javawebsession/input1" method="post" class="box">
			<label for="login"> ログインID&nbsp;<span class="required">必須</span>;&nbsp;
				<input type="text" id="login" name="login"
				value="<%=user.getLogin()%>">
			</label><br> <label for="passwd"> パスワード&nbsp;<span
				class="required">必須</span>;&nbsp; <input type="password" id="passwd"
				name="passwd">
			</label><br> <label for="passwd2"> パスワード再入力&nbsp;<spanclass-"required">必須</span>;&nbsp;
				<input type="password" id="passwd2" name="passwd2"></label><br>
			<button type="submit">次へ</button>
		</form>
	</section>
</body>
</html>