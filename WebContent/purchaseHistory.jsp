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
<jsp:include page="header.jsp"/>

<h1>商品購入履歴一覧画面</h1>


<!-- 購入履歴がない場合  -->

<s:if test="purchaseHistoryInfoDTOList.size() == 0">
	<s:property value="message"/>
</s:if>




<!-- 購入履歴がある場合  -->

<s:elseif test="purchaseHistoryInfoDTOList.size() != 0">
	<table>
		<tr>
			<th>商品名</th>
			<th>ふりがな</th>
			<th>商品画像</th>
			<th>値段</th>
			<th>個数</th>
			<th>合計金額</th>
		</tr>
		<s:iterator value="purchaseHistoryInfoDTOList">
		<tr>
			<td><s:property value="productName"/></td>
			<td><s:property value="productNameKana"/></td>
			<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'></td>
			<td><s:property value="price"/>円</td>
			<td><s:property value="productCount"/>個</td>
			<td><s:property value="totalPrice"/>円</td>
		</tr>
		</s:iterator>
		<s:form action="DeletePurchaseHistoryAction">
			<s:submit value="履歴削除"/>
		</s:form>
	</table>
</s:elseif>


<jsp:include page="footer.jsp"/>
</body>
</html>
