<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/purchaseHistory.css">
<title>商品購入履歴一覧</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
	<h1>商品購入履歴一覧画面</h1>

<!-- 購入履歴がない場合  -->
<s:if test="purchaseHistoryInfoDTOList.size() == 0">
	<p><s:property value="message"/></p>
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
			<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="100px" height="100px"></td>
			<td><s:property value="price"/>円</td>
			<td><s:property value="productCount"/>個</td>
			<td><s:property value="totalPrice"/>円</td>
		</tr>
		</s:iterator>
	</table>
	<s:form action="DeletePurchaseHistoryAction">
		<div class="submit_btn_box">
			<button type="submit" class="submit_btn">履歴削除</button>
		</div>
	</s:form>
</s:elseif>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
