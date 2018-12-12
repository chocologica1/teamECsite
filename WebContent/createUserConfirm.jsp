<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/create.css">
<title>ユーザ情報入力確認画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ユーザ情報入力確認画面</h1>
		<br>
		<s:form action="CreateUserCompleteAction">
			<table class="vertical-list-table">
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
					<th><s:label value="ユーザID" /></th>
					<td><s:property value="userId" /></td>
				</tr>
				<tr>
					<th><s:label value="パスワード" /></th>
					<td><s:property value="password" /></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<div class=".contents-btn-set">
					<s:submit value="登録" class="submit_btn" />
				</div>
			</div>
		</s:form>

		<s:form action="CreateUserAction">
			<div class="submit_btn_box">
				<s:submit value="戻る" class="submit_btn" />
			</div>
		</s:form>

	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>