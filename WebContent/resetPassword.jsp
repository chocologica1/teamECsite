<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/password.css">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>パスワード再設定画面</h1>

		<!-- ↓↓↓ エラーメッセージ ↓↓↓  -->
		<!-- ユーザID不適切  -->
		<s:if test="!#session.userIdErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.userIdErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<!-- 現在のパスワード不適切  -->
		<s:if test="!#session.passwordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.passwordErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<!-- ユーザIDまたはパスワードが間違っている  -->
		<s:if test="!#session.incorrectErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.incorrectErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<!-- 新しいパスワード不適切  -->
		<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.newPasswordErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<!-- 新しいパスワード(再確認)不適切  -->
		<s:if
			test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator
					value="#session.reConfirmationNewPasswordErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<!-- 新しいパスワードと(再確認)が不一致  -->
		<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.newPasswordIncorrectErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<!--     ここまで     -->

		<!-- ↓↓↓ パスワード再設定 入力欄 ↓↓↓  -->
		<s:form action="ResetPasswordConfirmAction">
			<table class="table">
				<tr>
					<td>ユーザID</td>
					<!-- 再遷移してきた場合  -->
					<s:if test="#session.savedUserId == true">
						<td><input type="text" name="userId" placeholder="ユーザID"
							value='<s:property value="#session.copyUserId"/>'
							class="textarea" /></td>
					</s:if>
					<!-- 初めて入力する場合  -->
					<s:else>
						<td><input type="text" name="userId" placeholder="ユーザID"
							value='<s:property value="userId"/>' class="textarea" /></td>
					</s:else>
				</tr>
				<tr>
					<td>現在のパスワード</td>
					<td><input type="password" name="password"
						placeholder="現在のパスワード" class="textarea" /></td>
				</tr>
				<tr>
					<td>新しいパスワード</td>
					<td><input type="password" name="newPassword"
						placeholder="新しいパスワード" class="textarea" /></td>
				</tr>
				<tr>
					<td>新しいパスワード（再確認）</td>
					<td><input type="password" name="reConfirmationNewPassword"
						placeholder="新しいパスワード（再確認）" class="textarea" /></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<button type="submit" class="submit_btn">確認</button>
			</div>
		</s:form>
		<!--    ここまで     -->

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>