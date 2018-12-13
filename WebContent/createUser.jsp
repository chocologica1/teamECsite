<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/create.css">
<title>ユーザ情報入力画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="contents">
		<h1>ユーザ情報入力画面</h1>

		<!-- エラーメッセージここから -->

		<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.familyNameErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.firstNameErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.familyNameKanaErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.firstNameKanaErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.emailErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.emailErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.userIdErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.userIdErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.passwordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.passwordErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<!-- ここまで -->

		<s:form action="CreateUserConfirmAction">

			<table class="vertical-list-table">
				<tr class="textBox">
					<th class="textTitle">姓</th>
					<s:if test="#session.savedUserInfo == true">
						<td><input type="text" name="familyName"
							value="<s:property value='#session.familyName'/>" placeholder="姓"
							class="textarea" /></td>
					</s:if>
					<s:else>
						<td><input type="text" name="familyName"
							value="<s:property value='familyName'/>" placeholder="姓"
							class="textarea" /></td>
					</s:else>
				</tr>

				<tr class="textBox">
					<th class="textareaTitle">名</th>
					<s:if test="#session.savedUserInfo == true">
						<td><input type="text" name="firstName"
							value="<s:property value='#session.firstName' />" placeholder="名"
							class="textarea" /></td>
					</s:if>
					<s:else>
						<td><input type="text" name="firstName"
							value="<s:property value='firstName' />" placeholder="名"
							class="textarea" /></td>
					</s:else>
				</tr>
				<tr class="textBox">
					<th class="textareaTitle">姓ふりがな</th>
					<s:if test="#session.savedUserInfo == true">
						<td><input type="text" name="familyNameKana"
							value="<s:property value='#session.familyNameKana' />"
							placeholder="姓ふりがな" class="textarea" /></td>
					</s:if>
					<s:else>
						<td><input type="text" name="familyNameKana"
							value="<s:property value='familyNameKana' />" placeholder="姓ふりがな"
							class="textarea" /></td>
					</s:else>
				</tr>
				<tr>
					<th class="textareaTitle">名ふりがな</th>
					<s:if test="#session.savedUserInfo == true">
						<td><input type="text" name="firstNameKana"
							value="<s:property value='#session.firstNameKana' />"
							placeholder="名ふりがな" class="textarea" /></td>
					</s:if>
					<s:else>
						<td><input type="text" name="firstNameKana"
							value="<s:property value='firstNameKana' />" placeholder="名ふりがな"
							class="textarea" /></td>
					</s:else>
				</tr>
				<tr>
					<th>性別</th>
					<s:if test="#session.sex == 1">
						<td><input type="radio" id="0" name="sex" value="0" />男性 <input
							type="radio" id="1" name="sex" value="1" checked />女性</td>
					</s:if>
					<s:else>
						<td><input type="radio" id="0" name="sex" value="0" checked />男性
							<input type="radio" id="1" name="sex" value="1" />女性</td>
					</s:else>
				</tr>

				<tr>
					<th>メールアドレス</th>
					<s:if test="#session.savedUserInfo == true">
						<td><input type="text" name="email"
							value="<s:property value='#session.email' />"
							placeholder="メールアドレス" class="textarea" /></td>
					</s:if>
					<s:else>
						<td><input type="text" name="email"
							value="<s:property value='email' />" placeholder="メールアドレス"
							class="textarea" /></td>
					</s:else>
				</tr>

				<tr>
					<th>ユーザID</th>
					<s:if test="#session.savedUserInfo == true">
						<td><input type="text" name="userId"
							value="<s:property value='#session.userId' />"
							placeholder="ユーザID" class="textarea" /></td>
					</s:if>
					<s:else>
						<td><input type="text" name="userId"
							value="<s:property value='userId' />" placeholder="ユーザID"
							class="textarea" /></td>
					</s:else>
				</tr>

				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password" value=""
						placeholder="パスワード" class="textarea" /></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>