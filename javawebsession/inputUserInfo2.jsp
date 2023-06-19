<%--
JavaWebSession Lesson Src04

ユーザー情報入力画面２。

ファイル名=inputUserInfo2.jsp
ディレクトリ=/javawebsession/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="local.hal.night.javawebsession.*"%>
<%
	User user = (User) session.getAttribute("userInfo");
	List<String> validationMsgs = (List<String>) request.getAttribute("validationMsgs");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>ユーザー情報入力画面２</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
	<h1>ユーザー情報入力画面2</h1>
	<nav id="breadcrumbs">
		<ul>
			<li><a href="/javawebsession/inputUserInfo1.jsp">入力１</a></li>
			<li class="current">入力２</li>
			<li>確認</li>
			<li>完了</li>
		</ul>
	</nav>
	<%
		if (validationMsgs != null) {
	%>
	<section id="errormsg">
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
		<form action="/javawebsession/input2" method="post" class="box">
			<label for="nameLast"> 姓&nbsp;<span class="required">必須</span>;&nbsp;
				<input type="text" id="nameLast" name="nameLast"
				value="<%=user.getNameLast()%>">
			</label><br> <label for="nameFirst"> 名&nbsp;<span
				class="required">必須</span>;&nbsp; <input type="text" id="nameFirst"
				name="nameFirst" value="<%=user.getNameFirst()%>">
			</label><br> <label for="mail"> メール&nbsp;<span class="required">必須</span>;&nbsp;
				<input type="email" id="mail" name="mail"
				value="<%=user.getMail()%>">
			</label><br>
			<button type="submit">次へ</button>
		</form>
	</section>
</body>
</html>