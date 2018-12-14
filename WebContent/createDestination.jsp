<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/create.css">
<title>宛先情報入力</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="contents">
	<h1>宛先情報入力画面</h1>

	<!-- エラーメッセージ -->
		<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>

		</s:if>
		<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!#session.emailErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="#session.emailErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>

	<!-- ここまで -->

	<s:form action="CreateDestinationConfirmAction">
		<table class="vertical-list-table">
			<tr>
				<th>姓</th>
					<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="familyName"
					value="<s:property value='#session.familyName' />" placeholder="姓" class = "textarea" /></td>
				</s:if>
				<s:else>
					<td><input type="text" name="familyName"
					value="<s:property value='familyName' />" placeholder="姓" class="textarea" /></td>
				</s:else>
			</tr>
			<tr class="textBox">
				<th>名</th>
				<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="firstName"
					value="<s:property value='#session.firstName' />" placeholder="名" class = "textarea"/></td>
				</s:if>
				<s:else>
					<td><input type="text" name="firstName"
					value="<s:property value='firstName' />" placeholder="名" class="textarea" /></td>
				</s:else>
			</tr>
			<tr>
				<th>姓ふりがな</th>
				<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="familyNameKana"
					value="<s:property value='#session.familyNameKana' />" placeholder="姓ふりがな" class = "textarea"/></td>
				</s:if>
				<s:else>
					<td><input type="text" name="familyNameKana"
					value="<s:property value='familyNameKana' />" placeholder="姓ふりがな" class="textarea" /></td>
				</s:else>
			</tr>
			<tr>
				<th>名ふりがな</th>
				<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="firstNameKana"
					value="<s:property value='#session.firstNameKana' />" placeholder="名ふりがな" class = "textarea"/></td>
				</s:if>
				<s:else>
					<td><input type="text" name="firstNameKana"
					value="<s:property value='firstNameKana' />" placeholder="名ふりがな" class="textarea" /></td>
				</s:else>
			</tr>
			<tr>
				<th>住所</th>
				<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="userAddress"
					value="<s:property value='#session.userAddress' />" placeholder="住所" class = "textarea" /></td>
				</s:if>
				<s:else>
					<td><input type="text" name="userAddress"
					value="<s:property value='userAddress' />" placeholder="住所" class="textarea" /></td>
				</s:else>
			</tr>
			<tr>
				<th>電話番号</th>
				<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="telNumber"
					value="<s:property value='#session.telNumber' />" placeholder="電話番号" class = "textarea" /></td>
				</s:if>
				<s:else>
					<td><input type="text" name="telNumber"
					value="<s:property value='telNumber' />" placeholder="電話番号" class="textarea" /></td>
				</s:else>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<s:if test="#session.savedDestinationInfo == true">
					<td><input type="text" name="email"
					value="<s:property value='#session.email' />" placeholder="メールアドレス" class = "textarea"/></td>
				</s:if>
				<s:else>
					<td><input type="text" name="email"
					value="<s:property value='email' />" placeholder="メールアドレス" class="textarea" /></td>
				</s:else>
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