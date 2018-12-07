<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>パスワード再設定完了</title>
<script>
setTimeout(function(){
	  window.location.href = 'HomeAction';
	}, 3*1000);
</script>
</head>
<body>
<jsp:include page="header.jsp"/>

<h1>パスワード再設定完了画面</h1>

<p>パスワードの再設定が完了しました。</p>

<jsp:include page="footer.jsp"/>
</body>
</html>
