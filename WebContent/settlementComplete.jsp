<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>決済完了画面</title>
</head>
<body>

	<!-- ヘッダー -->
<%-- 	<s:include value="header.jsp"/> --%>

	<!-- メイン -->
	<div id="main">

		<!-- コンテンツ -->
		<div id="contents">
			<!-- メッセージを表示 -->
			<div id="message">
				決済が完了しました。
<%-- 				<s:property value="message"/> --%>
			</div>
		</div>

	</div>

	<!-- フッター -->
	<s:include value="footer.jsp"/>

</body>
</html>
