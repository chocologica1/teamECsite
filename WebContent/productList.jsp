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

	<h2>商品一覧画面</h2>

	<!-- 検索エラー -->
	<s:if test="!#session.keywordsErrorMessageList.isEmpty()">
		<s:iterator value="#session.keywordsErrorMessageList">
			<s:property/><br>
		</s:iterator>
	</s:if>

	<!-- 検索結果なし -->
	<s:elseif test="productInfoDTOList.size() == 0">
		<p>検索結果がありません。</p>
	</s:elseif>

	<!-- 一覧表示 -->
	<s:else>
		<s:iterator value="productInfoDTOList">
			<img src="<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>" alt="product" />
			<s:property value="productName"/>
			<s:property value="productNameKana"/>
			<s:property value="price"/>
		</s:iterator>
	</s:else>
</body>
</html>