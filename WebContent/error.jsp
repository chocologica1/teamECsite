<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;<s:url action='HomeAction'/>">
<title>Error</title>
</head>
<body>
	<div id="contents">
		<h1>エラー画面</h1>
		<div>エラーが発生しました。</div>
		<div>3秒後にホーム画面に自動的に遷移します。</div>
	</div>
</body>
</html>