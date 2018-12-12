<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href=""> -->
<title>宛先情報入力確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="contents">>
		<h1>宛先情報入力確認画面</h1>

		<p>以下の内容で登録します</p>
		<br>
		<s:form action="CreateDestinationCompleteAction">
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
					<th><s:label value="住所" /></th>
					<td><s:property value="userAddress" /></td>
				</tr>
				<tr>
					<th><s:label value="電話番号" /></th>
					<td><s:property value="telNumber" /></td>
				</tr>

				<tr>
					<th><s:label value="メールアドレス" /></th>
					<td><s:property value="email" /></td>
				</tr>
			</table>
			<s:submit value="登録" />
		</s:form>

		<s:form action="CreateDestinationAction" >
			<s:submit value="戻る" />
		</s:form>
	</div>

</body>
</html>