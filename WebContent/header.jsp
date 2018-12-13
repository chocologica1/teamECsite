<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- ↓ viewport表記必要か確認 -->
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/header.css">
<title>ヘッダー</title>

<script>
	/* ボタン */
	function goLoginAction() {
		document.getElementById("form").action = "GoLoginAction";
	}

	function goMyPageAction() {
		document.getElementById("form").action = "MyPageAction";
	}

	function goCartAction() {
		document.getElementById("form").action = "CartAction";
	}

	function goProductListAction() {
		document.getElementById("form").action = "ProductListAction";
	}

	function goLogoutAction() {
		document.getElementById("form").action = "LogoutAction";
	}

	function goSearchItemAction() {
		document.getElementById("form").action = "SearchItemAction";
	}
</script>
</head>
<body>
  <header>
  	<div id="header-contents">
		<div id="header-title">
			<p>Sunflower</p>
		</div>
		<div id="header-menu">
			<ul class="header-list">
				<s:form id="form" name="form">
					<!-- ログイン/未ログイン共通 -->
					<s:if test='#session.containsKey("mCategoryDTOList")'>
						<li><s:select name="categoryId"
								list="#session.mCategoryDTOList" listValue="categoryName"
								listKey="categoryId" class="category-select"/></li>
					</s:if>
					<li class="search-box"><s:textfield name="keywords" class="search-keywords" placeholder="検索ワード" /></li>
					<li><s:submit value="商品検索" class="header_btn" onclick="goSearchItemAction();" /></li>

					<!-- ログイン時 -->
					<s:if test="#session.loginFlg == true">
						<li><s:submit value="ログアウト" class="header_btn" onclick="goLogoutAction();" /></li>
					</s:if>

					<!-- 未ログイン時 -->
					<s:else>
						<li><s:submit value="ログイン" class="header_btn" onclick="goLoginAction();" /></li>
					</s:else>

					<!-- ログイン/未ログイン共通 -->
					<li><s:submit value="カート" class="header_btn" onclick="goCartAction();" /></li>

					<li><s:submit value="商品一覧" class="header_btn" onclick="goProductListAction();" /></li>

					<!-- ログイン時 -->
					<s:if test="#session.loginFlg == true">
						<li><s:submit value="マイページ" class="header_btn" onclick="goMyPageAction();" /></li>
					</s:if>
				</s:form>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</header>

</body>
</html>
