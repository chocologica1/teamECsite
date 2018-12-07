<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>商品一覧</title>
</head>
<body>
 	<jsp:include page="header.jsp"/>

	<h2>商品一覧画面</h2>

	<!-- 検索エラー -->
	<s:if test="!#session.keywordsErrorMessageList.isEmpty()">
		<div>
			<s:iterator value="#session.keywordsErrorMessageList">
				<s:property/><br>
			</s:iterator>
		</div>
	</s:if>

	<!-- 検索結果/商品情報なし -->
	<s:elseif test="productInfoDTOList.isEmpty()">
		<div>
			<p>検索結果がありません。</p>
		</div>
	</s:elseif>

	<!-- 商品情報あり -->
	<s:else>
		<s:iterator value="productInfoDTOList">
			<div>
				<div>
					<!-- 画像をクリックすると商品IDをActionに渡す -->
					<a href='<s:url action="ProductDetailsAction">
						<s:param name="productId" value="productId"/></s:url>'>
						<img src="<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>"alt="product" />
					</a>
				</div>
				<s:property value="productName" /><br>
				<s:property value="productNameKana"/><br>
				¥<s:property value="price"/>
			</div>
		</s:iterator>
	</s:else>
</body>
</html>