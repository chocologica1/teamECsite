<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>パスワード再設定確認画面</title>
</head>
<body>

<table>
	<tr>
		<td>ユーザID</td>
		<td><s:property value=""/></td>
	</tr>
	<tr>
		<td>新しいパスワード</td>
		<td><s:property value=""/></td>
	</tr>
	<tr>
		<td><input type="button" value="戻る" name=""/></td>
	</tr>
	<tr>
		<td><input type="button" value="パスワード再設定" name=""/></td>
	</tr>
</table>

</body>
</html>





