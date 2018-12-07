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
	<jsp:include page="header.jsp"/>

	<div>
		<h1>ユーザー情報入力画面</h1>

		<!-- エラーメッセージここから -->
		<div class="errorMessage">
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<s:iterator value="#session.familyNameErrorMessageList"><s:property/>
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<s:iterator value="#session.firstNameErrorMessageList"><s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<s:iterator value="#session.emailErrorMessageList"><s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.userIdErrorMessageList.isEmpty()">
				<s:iterator value="#session.userIdErrorMessageList"><s:property />
				</s:iterator>
				<br>
			</s:if>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
				<s:iterator value="#session.passwordErrorMessageList"><s:property />
				</s:iterator>
				<br>
			</s:if>
		</div>
		<!-- ここまで -->

		<s:form action="CreateUserConfirmAction">
			<table>
				<tr class="textBox">
					<th class="textTitle">姓</th>
					<td><input type="text" name="familyName"
							value="<s:property value='familyName' />" placeholder="姓" class="text" /></td>
				</tr>

				<tr class="textBox">
					<th class="txtTitle">名</th>
					<td><input type="text" name="firstName"
							value="<s:property value='firstName' />" placeholder="名" class="text" />
				<tr>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">姓ふりがな</th>
					<td><input type="text" name="familyNameKana"
							value="<s:property value='familyNameKana' />" placeholder="姓ふりがな"
							class="text" /></td>
				</tr>
				<tr class="textBox">
					<th class="txtTitle">名ふりがな</th>
					<td><input type="text" name="firstNameKana"
							value="<s:property value='firstNameKana' />" placeholder="名ふりがな"
							class="text" /></td>
				</tr>
				<tr>
					<th>性別</th>
						<td><input type="radio" id="0" name="sex" value="0" checked />男性</td>
						<td><input type="radio" id="1" name="sex" value="1" />女性</td>
				</tr>

				<tr>
					<th>メールアドレス</th>
					<td><input type="text" name="email" value="<s:property value='email' />"
							placeholder="メールアドレス" class="text" /></td>
				</tr>

				<tr>
					<th>ユーザID</th>
					<td><input type="text" name="userId" value="<s:property value='userId' />"
							placeholder="ユーザID" class="text" /></td>
				</tr>

				<tr class="txtBox">
					<th>パスワード</th>
					<td><input type="text" name="password" value="<s:property value='password' />"
							placeholder="パスワード" class="text" /></td>
				</tr>
			</table>
			<s:submit value="登録" class="submit_btn" />
		</s:form>
	</div>

	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>