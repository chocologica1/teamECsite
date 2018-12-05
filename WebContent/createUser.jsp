<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>ユーザー登録画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div class="main">
		<h1>ユーザー情報入力画面</h1>

		<!-- エラーメッセージここから -->
		<div class="errorMessage">
				<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
					<s:iterator value="#session.familyNameErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
					<s:iterator value="#session.firstNameErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
					<s:iterator value="#session.familyNameKanaErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
					<s:iterator value="#session.firstNameKanaErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.emailErrorMessageList.isEmpty()">
					<s:iterator value="#session.emailErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<s:iterator value="#session.loginIdErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
				<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<s:iterator value="#session.passwordErrorMessageList"><br><s:property /></s:iterator>
				</s:if>
			</div>
		<!-- エラーメッセージここまで。ページ上部に表示する感じ -->

		<s:form action="CreateUserConfirmAction">
			<table class="CreateUserForm">
				<tr class="textBox">
					<th class="textTitle">姓</th>
					<td><s:textfield name="familyName" value="%{#session.familyName}" placeholder="姓" class="text" /></td>
				</tr>

				<tr class="textBox">
					<th class="txtTitle">名</th>
					<td><s:textfield name="firstName" value="%{#session.firstName}" placeholder="名" class="text" /><tr>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">姓ふりがな</th>
					<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" placeholder="姓ふりがね" class="text" /></td>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">名ふりがな</th>
					<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" placeholder="名ふりがな" class="text" /></td>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">性別</th>
					<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" placeholder="性別"  class="text"/></td>
				</tr>

				<tr class="txtBox">
					<th class="txtTitle">メールアドレス</th>
					<td><s:textfield name="email" value="%{#session.email}" placeholder="メールアドレス" class="text" /></td>
				</tr>

				<tr class="txtBox">
					<th class="txtTitle">ログインID</th>
					<td><s:textfield name="loginId" value="%{#session.loginId}" placeholder="ログインID" class="text" /></td>
				</tr>

				<tr class="txtBox">
					<th class="txtTitle">パスワード</th>
					<td><s:textfield name="password" value="%{#session.password}" placeholder="パスワード" class="text" /></td>
				</tr>
			</table>s
					<s:submit value="登録" class="submit_btn" />
		</s:form>
	</div>

	<div id="header">
		<div id="pr">
		</div>
	</div>
</body>
</html>