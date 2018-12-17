<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/password.css">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>パスワード再設定確認画面</h1>
		<s:form action="ResetPasswordCompleteAction">
			<table class="table">
				<tr>
					<td>ユーザID</td>
					<td><s:property value="#session.copyUserId" /></td>
					<!-- 改めてユーザIDを確認  -->
				</tr>
				<tr>
					<td>新しいパスワード</td>
					<td><s:property value="#session.hiddenPassword" /></td>
					<!-- 改めて新パスワードを*で表示  -->
				</tr>
			</table>
			<div class="submit_btn_box">
				<button type="submit" class="submit_btn">パスワード再設定</button>
			</div>
		</s:form>
		<s:form action="ResetPasswordAction">
			<div class="submit_btn_box">
				<input type="hidden" name="reFlg" value="2" />
				<button type="submit" class="submit_btn">戻る</button>
			</div>
		</s:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>