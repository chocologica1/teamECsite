<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>カート画面</title>
</head>
<body>
	<!-- カートに商品が入っている場合 -->
 	<s:if test="true">
		<s:form action="DeleteCartAction">
			<div id="cart">
				<s:iterator value="cartInfoDTOList">
					<table class="product">
						<tr>
							<!--
								削除対象チェックボックス
								DeleteCartActionのproductIdMapに「key:商品ID」「value:商品ID」で格納する。
							-->
							<td>削除</td>
							<td><input type="checkbox" value="<s:property value='productId' />" name="productIdMap(<s:property value='productId'/>)"></td>
						</tr>
						<tr>
							<td>商品名</td>
							<td><s:property value="productName"/></td>
						</tr>
						<tr>
							<td>商品名(ふりがな)</td>
							<td><s:property value="productNameKana"/></td>
						</tr>
						<tr>
							<td>発売会社名</td>
							<td><s:property value="releaseCompany"/></td>
						</tr>
						<tr>
							<td>発売年月日</td>
							<td><s:property value="releaseDate"/></td>
						</tr>
						<tr>
							<td>購入個数</td>
							<td><s:property value="productCount"/></td>
						</tr>
						<tr>
							<td>合計金額</td>
							<td><s:property value="productCount"/></td>
						</tr>
					</table>
				</s:iterator>
			</div>

			<!-- 削除ボタン -->
			<div id="delete">
				<s:submit value="削除"/>
			</div>
		</s:form>

		<!-- カート合計金額 -->
		<div class="totalPrice">
			<s:property value="totalPrice"/>円
		</div>

		<!-- 決済ボタン -->


			<div class="settlement">
				<s:form action="SettlementConfirmAction">
					<s:submit value="決済"/>
				</s:form>
			</div>
 	</s:if>


	<!-- カートに商品が入っていない場合 -->

	<s:else>
		<div class="message">カート情報なし</div>
	</s:else>
</body>
</html>
