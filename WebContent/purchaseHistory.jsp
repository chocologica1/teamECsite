<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>商品購入履歴一覧</title>
</head>
<body>

<h1>商品購入履歴一覧画面</h1>

<s:if test="purchaseHistoryInfoDTOList.size() == 0">   <!-- 購入履歴がない場合  -->
	<s:property value="message"/>
</s:if>


<s:elseif test="purchaseHistoryInfoDTOList.size() > 0">    <!-- 購入履歴がある場合  -->
	<table>

		<tr>
		<s:iterator value="purchaseHistoryInfoDTOList">
			<td><s:property value="productName"/></td>
			<td><s:property value="productNameKana"/></td>
			<td><img src='<s:property value="imageFilePath"/>'></td>
			<td><s:property value="imageFileName"/></td>
			<td><s:property value="price"/></td>
			<td><s:property value="productCount"/></td>
			<td><s:property value="totalPrice"/></td>
		</s:iterator>
		</tr>

		<s:form action="DeletePurchaseHistoryAction">
			<s:submit value="削除"/>
		</s:form>

	</table>
</s:elseif>

</body>
</html>
