<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/create.css">
<meta http-equiv="refresh" content="3;<s:url action='LoginAction'/>">
<title>ユーザ情報入力完了画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ユーザ情報入力完了画面</h1>
		<div class="success">ユーザ登録が完了致しました。</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>