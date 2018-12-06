
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<link rel="stylesheet" href="">
<title>パスワード再設定</title>
</head>
<body>

<h1>パスワード再設定画面</h1>

<!-- ↓↓↓ エラーメッセージ ↓↓↓  -->

	<!-- ユーザID不適切  -->
	<s:if test="!#session.userIdErrorMessageList.isEmpty()">
		<s:iterator value="#session.userIdErrorMessageList"><s:property/><br>
		</s:iterator>
	</s:if>

	<!-- 現在のパスワード不適切  -->
	<s:if test="!#session.passwordErrorMessageList.isEmpty()">
		<s:iterator value="#session.passwordErrorMessageList"><s:property/><br>
		</s:iterator>
	</s:if>

	<!-- ユーザIDまたはパスワードが間違っている  -->
	<s:if test="!#session.incorrectErrorMessageList.isEmpty()">
		<s:iterator value="#session.incorrectErrorMessageList"><s:property/><br>
		</s:iterator>
	</s:if>

	<!-- 新しいパスワード不適切  -->
	<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
		<s:iterator value="#session.newPasswordErrorMessageList"><s:property/><br>
		</s:iterator>
	</s:if>

	<!-- 新しいパスワード(再確認)不適切  -->
	<s:if test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
		<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList"><s:property/><br>
		</s:iterator>
	</s:if>

	<!-- 新しいパスワードと(再確認)が不一致  -->
	<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
		<s:iterator value="#session.newPasswordIncorrectErrorMessageList"><s:property/><br>
		</s:iterator>
	</s:if>

<!--     ここまで     -->



<!-- ↓↓↓ パスワード再設定 入力欄 ↓↓↓  -->

<s:form action="ResetPasswordConfirmAction">
	<table>
		<tr>
			<td>ユーザID</td>
			<!-- 再遷移してきた場合  -->
			<s:if test="#session.saveduserId == true">
			<td><input type="text" name="userId" placeholder="ユーザID" value='<s:property value="#session.userId"/>'/></td>
			</s:if>
			<!-- 初めて入力する場合  -->
			<s:else>
			<td><input type="text" name="userId" placeholder="ユーザID"/></td>
			</s:else>
		</tr>
		<tr>
			<td>現在のパスワード</td>
			<td><input type="password" name="password" placeholder="現在のパスワード"/></td>
		</tr>
		<tr>
			<td>新しいパスワード</td>
			<td><input type="password" name="newPassword" placeholder="新しいパスワード"/></td>
		</tr>
		<tr>
			<td>新しいパスワード(再確認)</td>
			<td><input type="password" name="reConfirmationNewPassword" placeholder="新しいパスワード(再確認)"/></td>
		</tr>
		<s:submit value="確認"/>
	</table>
</s:form>

<!--    ここまで     -->


</body>
</html>