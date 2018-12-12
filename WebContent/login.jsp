<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/login.css">
<title>ログイン</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="contents">

	<h1>ログイン画面</h1>
	<s:form id="form" action="LoginAction">
	<!-- エラーメッセージの表示 -->
		<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
			<div class="message">
				<div class="error">
					<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.passwordErrorMessageList.isEmpty()">
			<div class="message">
				<div class="error">
					<s:iterator value="#session.passwordErrorMessageList"><s:property /><br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<!-- ユーザーIDもしくはパスワードが一致しない場合表示 -->
		<s:if test="notMatch != null">
			<div class="message">
				<div class="error">
						<s:property value="notMatch"/>
				</div>
			</div>
		</s:if>

	<table class="inputform">

		<tr>
			<th>ユーザID:</th>
				<s:if test="#session.savedLoginId == true">
					<td><s:textfield name="loginId" class="txt" placeholder="ユーザID" value='%{#session.keepLoginId}' autocomplete="off"/></td>
				</s:if>
			<s:else>
				<td><s:textfield name="loginId" class="txt" placeholder="ユーザID" autocomplete="off"/></td>
			</s:else>
		</tr>
		<tr>
			<th>パスワード:</th>
			<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off"/></td>
		</tr>
	</table><br>
	<div class="box">
		<s:if test="#session.savedLoginId==true">
			<s:checkbox name="savedLoginId" checked="checked"/>
		</s:if>			<s:else>
			<s:checkbox name="savedLoginId"/>
		</s:else>
		<s:label value="ユーザID保存"/><br>
	</div>
	<div class="submit_btn_box">
			<s:submit value="ログイン" class="submit_btn" onclick="goLoginAction();"/>
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