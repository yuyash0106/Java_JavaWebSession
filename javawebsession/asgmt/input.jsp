<%--
JavaWebSession Practice Src02

入力画面。

ファイル名=input.jsp
ディレクトリ=/javawebsession/asgmt
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="local.hal.night.javawebsession.asgmt.*"%>
<%@ page import="local.hal.night.javawebsession.asgmt.Number"%>
<%
	Integer inputNum = null;
	Integer currentNum = null;
	Integer sum = null;

	List<Integer> num = new ArrayList<>();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>入力画面</title>
</head>
<p>JavaWebSession 練習問題 入力画面</p>
<body>
	<p>
		現在の値：<%=session.getAttribute("currentNum")%></p>

	<form action="/javawebsession/asgmt/plus" method="post" class="box">
		<input type="number" id="number" name="number" required> <input
			type="submit" name="plus" value="加算"> <br>
	</form>
	<form action="/javawebsession/asgmt/clear" method="post" class="box">
		<input type="submit" name="clear" value="クリア">
	</form>

</body>
</html>