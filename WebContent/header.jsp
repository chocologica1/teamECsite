<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/style.css">
<title>ヘッダー</title>

<script>
  function goLoginAction(){
	  document.getElementById("form").action = "GoLoginAction";
  }

  function goMyPageAction(){
	  document.getElementById("form").action = "MyPageAction";
  }

  function goCartAction(){
	  document.getElementById("form").action = "CartAction";
  }

  function goProductListAction(){
	  document.getElementById("categoryId").value = 1;
	  document.getElementById("form").action = "ProductListAction";
  }

  function goLogoutAction(){
	  document.getElementById("form").action = "LogoutAction";
  }

  function goSearchItemAction(){
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
			<ul>
				<s:form id="form" name="form">
					<!-- ログイン/未ログイン共通 -->
					<s:if test='#session.containsKey("mCategoryDTOList")'>
						<li><s:select name="categoryId"
								list="#session.mCategoryDTOList" listValue="categoryName"
								listKey="categoryId" class="cs-div" id="categoryId" /></li>
					</s:if>
					<li><s:textfield name="keywords" class="txt-keywords" placeholder="検索キーワード" /></li>
					<li><s:submit value="商品検索" class="submit_btn" onclick="goSearchItemAction();" /></li>

					<!-- ログイン時 -->
					<s:if test="#session.loginFlg == true">
						<li><s:submit value="ログアウト" class="submit_btn" onclick="goLogoutAction();" /></li>
					</s:if>

					<!-- 未ログイン時 -->
					<s:else>
						<li><s:submit value="ログイン" class="submit_btn" onclick="goLoginAction();" /></li>
					</s:else>

					<!-- ログイン/未ログイン共通 -->
					<li><s:submit value="カート" class="submit_btn" onclick="goCartAction();" /></li>

					<li><s:submit value="商品一覧" class="submit_btn" onclick="goProductListAction();" /></li>

					<!-- ログイン時 -->
					<s:if test="#session.loginFlg == true">
						<li><s:submit value="マイページ" class="submit_btn" onclick="goMyPageAction();" /></li>
					</s:if>
				</s:form>
			</ul>
		</div>
	</div>
</header>

</body>
</html>
