<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/cart.css">
<link rel="stylesheet" href="./css/style.css">
<title>商品購入履歴一覧画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>商品購入履歴一覧画面</h1>

		<!-- 購入履歴がない場合  -->
		<s:if test="purchaseHistoryInfoDTOList.size() == 0">
			<div class="info">
				<s:property value="message" />
			</div>
		</s:if>

		<!-- 購入履歴がある場合  -->
		<s:elseif test="purchaseHistoryInfoDTOList.size() != 0">
			<table class="product">
			<thead>
				<tr>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>商品画像</th>
					<th>値段</th>
					<th>個数</th>
					<th>合計金額</th>
					<th>発売会社名</th>
					<th>発売年月日</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="purchaseHistoryInfoDTOList">
					<tr>
						<td><s:property value="productName" /></td>
						<td><s:property value="productNameKana" /></td>
						<td><img
							src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'>
							</td>
						<td><s:property value="price" />円</td>
						<td><s:property value="productCount" />個</td>
						<td><s:property value="totalPrice" />円</td>
						<td><s:property value="releaseCompany" /></td>
						<td><s:property value="releaseDate" /></td>
					</tr>
				</s:iterator>
			</tbody>
			</table>
			<s:form action="DeletePurchaseHistoryAction">
				<div class="submit_btn_box">
					<button type="submit" class="submit_btn">履歴削除</button>
				</div>
			</s:form>
		</s:elseif>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
