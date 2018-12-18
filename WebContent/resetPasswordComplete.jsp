<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/password.css">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定完了画面</title>
<script>
	setTimeout(function() {
		window.location.href = 'HomeAction';
	}, 3 * 1000);
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>パスワード再設定完了画面</h1>
		<div class="complete">パスワードの再設定が完了しました。</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
