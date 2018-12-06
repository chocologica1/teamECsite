<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">


<s:if test="session.cartFlg == 1">
	<meta http-equiv="refresh" content="3;<s:url action='SettlementConfirmAction'/>">
</s:if>
<s:else>
	<meta http-equiv="refresh" content="3;<s:url action='HomeAction'/>">
</s:else>


<title>ユーザー情報入力完了画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="contents">
		<h1>登録完了画面</h1>
		<div class="success">ユーザー登録が完了致しました。</div>
	</div>
	<div id="footer"></div>

</body>