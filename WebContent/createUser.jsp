<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>ユーザー登録画面</title>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>

	<div class="main">
		<h1>ユーザー情報入力画面</h1>

		<!-- エラーメッセージここから -->
		<div class="errorMessage">
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<s:iterator value="#session.familyNameErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<s:iterator value="#session.firstNameErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<s:iterator value="#session.familyNameKanaErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<s:iterator value="#session.firstNameKanaErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<s:iterator value="#session.emailErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
				<s:iterator value="#session.loginIdErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
				<s:iterator value="#session.passwordErrorMessageList">
					<s:property />
				</s:iterator>
				<br>
			</s:if>
		</div>
		<!-- エラーメッセージここまで -->

		<s:form action="CreateUserConfirmAction">
			<table>
				<tr class="textBox">
					<th class="textTitle">姓</th>
					<td><input type="text" name="familyName"
							value="%{#session.familyName}" placeholder="姓" class="text" /></td>
				</tr>

				<tr class="textBox">
					<th class="txtTitle">名</th>
					<td><input type="text" name="firstName"
							value="%{#session.firstName}" placeholder="名" class="text" />
				<tr>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">姓ふりがな</th>
					<td><input type="text" name="familyNameKana"
							value="%{#session.familyNameKana}" placeholder="姓ふりがね"
							class="text" /></td>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">名ふりがな</th>
					<td><input type="text" name="firstNameKana"
							value="%{#session.firstNameKana}" placeholder="名ふりがな"
							class="text" /></td>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">性別</th>
						<td><s:radio name="sex" list="sexList" value="defaultSexValue" label="性別" placeholder="性別"/></td>
<!-- 						<td><input type="radio" id="0" name="sex" value="%{#session.sex}" />男性</td> -->
<!-- 						<td><input type="radio" id="1" name="sex" value="%{#session.sex}" />女性</td> -->
				</tr>

				<tr class="txtBox">
					<th class="txtTitle">メールアドレス</th>
					<td><input type="text" name="email" value="%{#session.email}"
							placeholder="メールアドレス" class="text" /></td>
				</tr>

				<tr class="txtBox">
					<th class="txtTitle">ログインID</th>
					<td><input type="text" name="loginId" value="%{#session.loginId}"
							placeholder="ログインID" class="text" /></td>
				</tr>

				<tr class="txtBox">
					<th class="txtTitle">パスワード</th>
					<td><input type="text" name="password" value="%{#session.password}"
							placeholder="パスワード" class="text" /></td>
				</tr>
			</table>
			<s:submit value="登録" class="submit_btn" />
		</s:form>
	</div>

	<div id="header">
		<div id="pr"></div>
	</div>
</body>
</html>