<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>login画面</title>
</head>
<body>
	<!-- <jsp:include page="header.jsp" /> -->
	<h1>ログイン画面</h1>
	<s:form id="form" action="LoginAction">
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
	</s:form>

	<table class="vertical-list-table">
		<tr>
			<th>ログインID</th>
		</tr>
		<tr>
			<!-- <td><s:if test="#session.savedLoginId == true"></s:if> -->
	</table>
</body>
</html>