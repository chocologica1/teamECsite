<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>宛先情報入力</title>
</head>
<body>
<jsp:include page="header.jsp" />
<title>宛先情報入力画面</title>

<!-- エラーメッセージ -->
<!-- ここまで -->

<s:form action="CreateDestinationConfirmAction" >
	<table>
		<tr>
			<th>姓</th>
			<td><input type="text" name="familyName" value="" placeholder="姓" /></td>
		</tr>
		<tr>
			<th>名</th>
			<td><input type="text" name="firstName" value="" placeholder="名" /></td>
		</tr>
		<tr>
			<th>姓ふりがな</th>
			<td><input type="text" name="familyNameKana" value="" placeholder="姓ふりがな" /></td>
		</tr>
		<tr>
			<th>名ふりがな</th>
			<td><input type="text" name="firstNameKana" value="" placeholder="名ふりがな" /></td>
		</tr>

	</table>
</s:form>


</body>
</html>