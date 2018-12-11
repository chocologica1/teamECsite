<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="./css/te"> -->
<title>商品詳細</title>
</head>
<body>
  	<jsp:include page="header.jsp"/>
	<div id="main">
		<div id="contents">
			<h1>商品詳細</h1>
			<div class="produvct-wrapper">
				<div class="details-image-box">
					<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' alt="product" class="product-image"/>
				</div>
				<div class="details-box">
					<s:form action="AddCartAction">
						<div>
							<table>
								<tr>
									<td>商品名</td>
									<td><s:property value="productName" /></td>
								</tr>
								<tr>
									<td>商品名かな</td>
									<td><s:property value="productNameKana" /></td>
								</tr>
								<tr>
									<td>値段</td>
									<td>¥<s:property value="price" /></td>
								</tr>
								<tr>
									<td>購入個数</td>
									<td>
										<!-- カートに購入個数を渡す -->
										 <select name="productCount">
											<option value="1" selected="selected">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select> 個
									</td>
								</tr>
								<tr>
									<td>発売会社名</td>
									<td><s:property value="releaseCompany" /></td>
								</tr>
								<tr>
									<td>発売年月日</td>
									<td><s:property value="releaseDate" /></td>
								</tr>
								<tr>
									<td>商品詳細情報</td>
									<td><s:property value="productDescription" /></td>
								</tr>
							</table>
						</div>
						<div class="submit_btn_box">
							<!-- カートに商品IDを渡す -->
							<input type="hidden" name="productId"
								value="<s:property value='productId'/>" />
							<s:submit type="button" value="カートに追加" cssClass="submit_btn" />
						</div>
					</s:form>
				</div>
			</div>

			<!-- 関連商品 -->
			<div class="category-wrapper">
				<s:iterator value="productInfoDTOList">
					<div class="category-box">
						<div class="category-image-box">
							<a href='<s:url action="ProductDetailsAction"><s:param name="productId" value="productId"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' alt="product" class="product-image"/>
							</a>
						</div>
						<s:property value="productName"/>
					</div>
				</s:iterator>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>