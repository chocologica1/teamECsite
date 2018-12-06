<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href=""> -->
<title>登録内容の確認</title>
</head>
<body>
	<div id="header">
	</div>
	<div>
		<div class="pageTitle">登録内容確認画面</div>
		<br>
		<p>以下の内容で登録します</p>
		<br>
		<s:form action="CreateUserCompleteAction">
				<table>
					<tr>
						<th><s:label value="姓" /></th>
						<td><s:property value="familyName" /></td>
					</tr>
					<tr>
						<th><s:label value="名" /></th>
						<td><s:property value="firstName" /></td>
					</tr>
					<tr>
						<th><s:label value="姓ふりがな" /></th>
						<td><s:property value="familyNameKana" /></td>
					</tr>
					<tr>
						<th><s:label value="名ふりがな" /></th>
						<td><s:property value="firstNameKana" /></td>
					</tr>
					<tr>
						<th><s:label value="性別" /></th>
						<td><s:property value="sex" /></td>
					</tr>
					<tr>
						<th><s:label value="メールアドレス" /></th>
						<td><s:property value="email" /></td>
					</tr>
					<tr>
						<th><s:label value="ログインID" /></th>
						<td><s:property value="loginID" /></td>
					</tr>
					<tr>
						<th><s:label value="パスワード" /></th>
						<td><s:property value="password" /></td>
					</tr>
				</table>
					<s:submit value="登録情報を確定" />
		</s:form>
	</div>
	<div id="footer">
	</div>

</body>
</html>