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
	<jsp:include page="header.jsp" />
	<h1>ログイン画面</h1>
	<s:form id="form" action="LoginAction">
		<s:if test="!#session.loginIdErrorMessageList.isEmpry()">
</body>
</html>