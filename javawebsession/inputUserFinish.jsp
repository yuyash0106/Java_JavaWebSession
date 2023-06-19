<%--
javaWebSession Lesson Src08

完了画面。

ファイル名=inputUserFinish.jsp
ディレクトリ=/javawebsession/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="local.hal.night.javawebsession.*"%>
<%
	String errorMsg = (String) request.getAttribute("errorMsg");
	User user = (User) request.getAttribute("userInfo");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>ユーザー情報登録完了画面</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
	<h1>ユーザー情報登録完了画面</h1>
	<nav id="breadcrumbs">
		<ul>
			<li>入力１</li>
			<li>入力2</li>
			<li>確認</li>
			<li class="current">完了</li>
		</ul>
	</nav>
	<section>
		<%
			if (errorMsg != null) {
		%>
		<p>
			<%=errorMsg%><br> <a href="/javawebsession/inputUserInfo1.jsp">入力画面１に戻る</a>
		</p>
		<%
			} else {
		%>
		<p>以下の情報を登録しました。</p>
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
		<%
			}
		%>
	</section>
</body>
</html>