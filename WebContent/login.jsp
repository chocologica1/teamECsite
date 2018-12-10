<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ログイン</title>

<script>

function goLoginAction(){
	document.getElementById("form").action="LoginAction";
}
function goCreateUseerAction(){
	document.getElementById("form").action="CreateUserAction";
}
function goResetPasswordAction(){
	document.getElementById("form").action="ResetPasswordAction";
}
</script>

</head>
<body>
	<!-- <jsp:include page="header.jsp" /> -->
	<h1>ログイン画面</h1>
	<s:form id="form" action="LoginAction">
	<!-- エラーメッセージの表示 -->
		<s:if test="!#session.loginIdErrorMessageList.isEmpry()">
			<div class="error">
				<div class="errormessage">
					<s:iterator value="#session.loginIdErrorMessageList"></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.passwordErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.passwordErrorMessageList"></s:iterator>
				</div>
			</div>
		</s:if>


	<table class="vertical-list-table">
		<tr>
			<th>ユーザーID</th>
		</tr>
		<tr>
			<td><s:if test="#session.savedLoginId == true">
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" value='%{#session.keepLoginId}' autocomplete="off"/></td>
			</s:if></td>
			<s:else>
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" autocomplete="off"/></td>
			</s:else>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off"/></td>
		</tr>
	</table>
	<div class="box">
		<s:if test="#session.savedLoginId==true">
			<s:checkbox name="savedLoginId" checked="checked"/>
		</s:if>
		<s:else>
			<s:checkbox name="savedLoginId"/>
		</s:else>
		<s:label value="ログインID保存"/><br>
	</div>
	<div class="submit_btn_box">
		<s:submit value="ログイン" class="submit_btn" onclick="goLoginAction();"/>
	</div>
	</s:form>

	<br>
<div class="submit_btn_box">
	<div id=".contents-btn-set">
		<s:form action="CreateUserAction">
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


<s:include value="footer.jsp"/>
</body>
</html>