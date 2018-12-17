<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/product.css">
<title>商品一覧画面</title>
</head>
<body>
 	<jsp:include page="header.jsp"/>
	<div id="contents">
		<h1>商品一覧画面</h1>

		<!-- 検索エラー -->
		<s:if test="!#session.keywordsErrorMessageList.isEmpty()">
				<s:iterator value="#session.keywordsErrorMessageList">
					<div class="error">
						<s:property/><br>
					</div>
				</s:iterator>
		</s:if>
		<!-- 検索結果なし -->
		<s:elseif test="productInfoDTOList == null">
			<div class="info">
				<p>検索結果がありません。</p>
			</div>
		</s:elseif>

		<!-- 商品情報あり -->
		<s:else>
			<div class="contents-wrapper">
				<s:iterator value="productInfoDTOList">
					<div class="product-box">
						<div class="list-image-box">
							<!-- 画像をクリックすると商品IDをActionに渡す -->
							<a href='<s:url action="ProductDetailsAction">
									<s:param name="productId" value="productId"/></s:url>'>
								<img src="<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>" alt="product" class="product-image" />
							</a>
						</div>
						<div class="list-detail-box">
							<s:property value="productName" />
							<br>
							<s:property value="productNameKana" />
							<br>
							<s:property value="price" />円
						</div>
					</div>
				</s:iterator>
			</div>
		</s:else>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>