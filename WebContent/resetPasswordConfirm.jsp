<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>パスワード再設定確認</title>
</head>
<body>

<h1>パスワード再設定確認画面</h1>

<s:form action="ResetPasswordCompleteAction">
	<table>
		<tr>
			<td>ユーザID</td>
			<td><s:property value="#session.loginId"/></td>
		</tr>
		<tr>
			<td>新しいパスワード</td>
			<td><s:property value="#session.hiddenPassword"/></td>
		</tr>
	</table>
	<s:submit value="パスワード再設定"/>
</s:form>

<s:form action="ResetPasswordAction">
	<s:submit value="戻る"/>
</s:form>



</body>
</html>





