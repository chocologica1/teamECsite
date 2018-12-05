<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>パスワード再設定</title>
</head>
<body>
<h1>パスワード再設定画面</h1>

	<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
		<s:iterator value="!#session.loginIdErrorMessageList"></s:iterator>
	</s:if>

	<s:if test="!#session.passwordErrorMessageList.isEmpty()">
		<s:iterator value="!#session.passwordErrorMessageList"></s:iterator>
	</s:if>

	<s:if test="!#session.incorrectErrorMessageList.isEmpty()">
		<s:iterator value="!#session.incorrectErrorMessageList"></s:iterator>
	</s:if>

	<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
		<s:iterator value="!#session.newPasswordErrorMessageList"></s:iterator>
	</s:if>

	<s:if test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
		<s:iterator value="!#session.reConfirmationNewPasswordErrorMessageList"></s:iterator>
	</s:if>

	<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
		<s:iterator value="!#session.newPasswordIncorrectErrorMessageList"></s:iterator>
	</s:if>

<s:form action="ResetPasswordConfirmAction">
	<table>
		<tr>
			<td>ユーザID</td>
			<s:if test="#session.savedLoginId == true"> <!-- １度ユーザIDを入力して戻ってきた場合  -->
			<td><s:textfield name="loginId" placeholder="ユーザID" value="%{#session.loginId}"/></td>
			</s:if>
			<s:else> <!-- 初めて入力する場合  -->
			<td><s:textfield name="loginId" placeholder="ユーザID"/></td>
			</s:else>
		</tr>
		<tr>
			<td>現在のパスワード</td>
			<td><s:password name="password" placeholder="現在のパスワード"/></td>
		</tr>
		<tr>
			<td>新しいパスワード</td>
			<td><s:password name="newPassword" placeholder="新しいパスワード"/></td>
		</tr>
		<tr>
			<td>新しいパスワード(再確認)</td>
			<td><s:password name="reConfirmationNewPassword" placeholder="新しいパスワード(再確認)"/></td>
		</tr>
	</table>
	<s:submit value="確認"/>
</s:form>


</body>
</html>