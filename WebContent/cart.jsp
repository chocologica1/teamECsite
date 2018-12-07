<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>カート画面</title>
<script src="//code.jquery.com/jquery-1.12.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		$('.deleteCheck').click(function(){
			var check_count = $('.product :checked').length;
			if(check_count > 0){
				$("#deleteButton").removeAttr("disabled");
			}else{
				$("#deleteButton").attr("disabled","disabled");
			}
		})
	})
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<!-- カートに商品が入っている場合 -->
 	<s:if test="cartInfoDTOList.size() > 0">
		<s:form action="DeleteCartAction" name = "form">
			<div id="cart">
				<s:iterator value="cartInfoDTOList">
					<table class="product">
						<tr>
							<!--
								削除対象チェックボックス
								DeleteCartActionのproductIdMapに「key:商品ID」「value:商品ID」で格納する。
							-->
							<td>削除</td>
							<td><input type="checkbox" value="<s:property value='productId'/>" name="productIdMap(<s:property value='productId'/>)" class="deleteCheck"></td>
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
							<td>商品画像</td>
							<td><Img src="<s:property value='productImagePath'/>/<s:property value="imageFileName"/>"></td>
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
							<td><s:property value="price"/></td>
						</tr>
					</table>
				</s:iterator>
			</div>

			<!-- 削除ボタン -->
			<div id="delete">
				<input type="submit" value="削除" id="deleteButton" disabled = "disabled"/>
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

	<jsp:include page="footer.jsp"/>
</body>
</html>
