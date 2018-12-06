<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>商品詳細</title>
</head>
<body>
	<h2>商品詳細</h2>
	<!-- 画像 -->
	<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' alt="product" />
	<!-- 詳細/ボタン -->
	<s:form action="AddCartAction">
		<table>
			<tr>
				<td>商品名</td>
				<td><s:property value="productName"/></td>
			</tr>
			<tr>
				<td>商品名かな</td>
				<td><s:property value="productNameKana"/></td>
			</tr>
			<tr>
				<td>値段</td>
				<td>¥<s:property value="price"/></td>
			</tr>
			<tr>
				<td>購入個数</td>
				<td>
					<select name="productCount">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					個
				</td>
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
				<td>商品詳細情報</td>
				<td><s:property value="productDescription"/></td>
			</tr>
		</table>
		<s:param name="productId" value="productId"/>
		<s:submit type="button" value="カートに追加"/>
	</s:form>
	<!-- 関連商品 -->
	<s:iterator value="productInfoDTOList">
		<a href='<s:url action="ProductDetailsAction"><s:param name="productId" value="productInfoDTOList.productId"/></s:url>'>
			<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' alt="product" />
		</a>
		<s:property value="productName"/>
	</s:iterator>
</body>
</html>