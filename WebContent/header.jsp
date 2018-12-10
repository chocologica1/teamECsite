<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>ヘッダー</title>
<style type="text/css">

#header {
	position:fixed;
	top:0;
	left:0;
	float : left;
	width : 100%;
	height : 60px;
	background-color : #005392;
}

#header-menu {
float : left;
width : 80%;
margin-left : -30px;
}

#header-menu ul{
	float : left;
	marigin-top : 15px;
	margin-left : 20px;
	width : 100%;
}

#header-menu ul li{
	float : left;
	list-style : none;
	padding-left : 1%;
	color : white;
	font-size : 12px;
}

#header-title {
	float : left;
	height : 30px;
	margin-top : 17px;
	margin-left : 25px;
	width : 10%;
	font-family: 'Vidaloka', serif;
	color:#ffffff;
	font-size:17px;
}

.submit_btn_box{
	width : 45%;
	display : block;
	margin-top : 5px;
	margin-bottom : 5px;
	margin-left : 3%;
	padding-left : 42%;
	float : left;
}

.submit_btn {
    padding: 0.5em 1em;
    text-decoration:none;
    border-radius:100px;
    width:100px;
	height : 35px;
	margin-top : -5px;
	margin-left : 6px;
    font-size:10px;
    text-align:center;
    color:#fff;
    box-shadow:2px 2px #1a6ea0;
    background: #4b7ea1;
    background: -webkit-gradient(linear, left top, left bottom, from(#81a8cb), to(#4477a1) );
    background: -moz-linear-gradient(-90deg, #81a8cb, #4477a1);
    filter:  progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#81a8cb', endColorstr='#4477a1');
}

.submit_btn:hover{
    color:#fff;
    background-color:#49a9d4;
    box-shadow:2px 2px #1a6ea0;
    cursor: pointer;
    opacity:0.5;
    background: #81a8cb;
    background: -webkit-gradient(linear, left top, left bottom, from(#4477a1), to(#81a8cb) );
    background: -moz-linear-gradient(-90deg, #4477a1, #81a8cb);
    filter:  progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#4477a1', endColorstr='#81a8cb');
}

.submit_btn:active{
	background: #4477a1;
}


</style>
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
    <div id = "header">

    <div id = "header-title">
    Sunflower
    </div>

    <div id = "header-menu">
      <ul>
          <s:form id= "form" name = "form">
	<s:if test='#session.containsKey("mCategoryDTOList")'>
	<li><s:select name="categoryId" list="#session.mCategoryDTOList" listValue="categoryName" listKey = "categoryId" class="cs-div" id="categoryId"/></li>
	</s:if>

            <li><s:textfield name = "keywords" class = "txt-keywords" placeholder = "検索キーワード"/></li>
            <li><s:submit value = "商品検索" class = "submit_btn" onclick = "goSearchItemAction();"/></li>

            <s:if test = "#session.loginFlg == true">
              <li><s:submit value = "ログアウト" class = "submit_btn" onclick = "goLogoutAction();"/></li>
            </s:if>

            <s:else>
              <li><s:submit value = "ログイン" class = "submit_btn" onclick = "goLoginAction();"/></li>
            </s:else>

            <li><s:submit value = "カート" class = "submit_btn" onclick = "goCartAction();"/></li>

            <li><s:submit value = "商品一覧" class = "submit_btn" onclick = "goProductListAction();"/></li>

            <s:if test = "#session.loginFlg == true">
              <li><s:submit value = "マイページ" class = "submit_btn" onclick = "goMyPageAction();"/></li>
            </s:if>

          </s:form>
      </ul>
    </div>
    </div>
  </header>

</body>
</html>
