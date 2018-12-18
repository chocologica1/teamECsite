<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/login.css">
<title>ログイン</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="contents">

	<h1>ログイン画面</h1>
	<s:form id="form" action="LoginAction">
	<!-- エラーメッセージの表示 -->
		<s:if test="!loginIdErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="loginIdErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<s:if test="!passwordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="passwordErrorMessageList"><s:property /><br>
				</s:iterator>
			</div>
		</s:if>
		<!-- ユーザーIDもしくはパスワードが一致しない場合表示 -->
		<s:if test="!notMatch.isEmpty()">
			<div class="error">
				<s:property value="notMatch"/>
			</div>
		</s:if>

	<table class="inputform">

		<tr>
			<th>ユーザID:</th>
				<s:if test="#session.savedLoginId == true">
					<td><s:textfield name="loginId" class="textarea" placeholder="ユーザID" value='%{#session.keepLoginId}' autocomplete="off"/></td>
				</s:if>
			<s:else>
				<td><s:textfield name="loginId" class="textarea" placeholder="ユーザID" autocomplete="off"/></td>
			</s:else>
		</tr>
		<tr>
			<th>パスワード:</th>
			<td><s:password name="password" class="textarea" placeholder="パスワード" autocomplete="new-password"/></td>
		</tr>
	</table>
	<br>
		<s:if test="#session.savedLoginId==true">
			<s:checkbox name="savedLoginId" checked="checked"/>
		</s:if>
		<s:else>
			<s:checkbox name="savedLoginId"/>
		</s:else>
		<s:label value="ユーザID保存"/><br>
	<div class="submit_btn_box">
			<s:submit value="ログイン" class="submit_btn"/>
	</div>
	</s:form>
	<div class="submit_btn_box">
		<div id=".contents-btn-set">
		<s:form action="CreateUserAction">
		<input type="hidden" name="createUserFlg" value ="true"/>
			<s:submit value="新規ユーザー登録" class="submit_btn" />
		</s:form>
	</div>
</div>
<div class="submit_btn_box">
<div id=".contents-btn-set">
	<s:form action="ResetPasswordAction">
		<input type="hidden" name="reFlg" value="1"/>
		<s:submit value="パスワード再設定" class="submit_btn" />
	</s:form>
</div>
</div>

</div>

<s:include value="footer.jsp"/>
</body>
</html>