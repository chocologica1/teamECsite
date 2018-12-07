<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>宛先情報入力</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<!-- エラーメッセージ -->
	<div>
		<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
			<s:iterator value="#session.familyNameErrorMessageList"><s:property />
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
		<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
			<s:iterator value="#session.userAddressErrorMessageList"><s:property />
			</s:iterator>
			<br>
		</s:if>
		<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
			<s:iterator value="#session.telNumberErrorMessageList"><s:property />
			</s:iterator>
			<br>
		</s:if>
		<s:if test="!#session.emailErrorMessageList.isEmpty()">
			<s:iterator value="#session.emailErrorMessageList"><s:property />
			</s:iterator>
			<br>
		</s:if>

	</div>
	<!-- ここまで -->

	<s:form action="CreateDestinationConfirmAction">
		<table>
			<tr>
				<th>姓</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="familyName"
					value="<s:property value='#session.familyName' />" placeholder="姓" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="familyName"
					value="<s:property value='familyName' />" placeholder="姓" /></td>
				</s:else>
			</tr>
			<tr>
				<th>名</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="firstName"
					value="<s:property value='#session.firstName' />" placeholder="名" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="firstName"
					value="<s:property value='firstName' />" placeholder="名" /></td>
				</s:else>
			</tr>
			<tr>
				<th>姓ふりがな</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="familyNameKana"
					value="<s:property value='#session.familyNameKana' />" placeholder="姓ふりがな" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="familyNameKana"
					value="<s:property value='familyNameKana' />" placeholder="姓ふりがな" /></td>
				</s:else>
			</tr>
			<tr>
				<th>名ふりがな</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="firstNameKana"
					value="<s:property value='#session.firstNameKana' />" placeholder="名ふりがな" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="firstNameKana"
					value="<s:property value='firstNameKana' />" placeholder="名ふりがな" /></td>
				</s:else>
			</tr>

			<tr>
				<th>住所</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="userAddress"
					value="<s:property value='#session.userAddress' />" placeholder="住所" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="userAddress"
					value="<s:property value='userAddress' />" placeholder="住所" /></td>
				</s:else>
			</tr>
			<tr>
				<th>電話番号</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="telNumber"
					value="<s:property value='#session.telNumber' />" placeholder="電話番号" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="telNumber"
					value="<s:property value='telNumber' />" placeholder="電話番号" /></td>
				</s:else>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<s:if test="#session.savedDestinationInfo == true">
				<td><input type="text" name="email"
					value="<s:property value='#session.email' />" placeholder="メールアドレス" /></td>
				</s:if>
				<s:else>
				<td><input type="text" name="email"
					value="<s:property value='email' />" placeholder="メールアドレス" /></td>
				</s:else>
			</tr>
		</table>
		<s:submit value="登録確認" />
	</s:form>

	<jsp:include page="footer.jsp" />
</body>
</html>