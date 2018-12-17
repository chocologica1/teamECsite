<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<meta http-equiv="refresh" content="3;<s:url action='HomeAction'/>"/>
<title>決済完了画面</title>
</head>
<body>

	<!-- ヘッダー -->
	<s:include value="header.jsp"/>

	<!-- コンテンツ -->
	<div id="contents">
		<h1>決済完了画面</h1>

		<!-- メッセージを表示 -->
		<div class="complete">
			決済が完了しました。
		</div>
	</div>

	<!-- フッター -->
	<s:include value="footer.jsp"/>

</body>
</html>
