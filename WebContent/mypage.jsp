<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>マイページ</title>
</head>
<body>

  <jsp:include page="header.jsp"/>
  <div id = "contents">
  <s:form action = "PurchaseHistoryAction">

  <!-- テーブル使用 -->
    <table>
      <tr>
        <th scope = "row"><s:label value = "姓"/></th>
        <td><s:property value = "userInfoDTO.familyName"/></td>
      </tr>

      <tr>
        <th scope = "row"><s:label value = "名"/></th>
        <td><s:property value = "userInfoDTO.firstName"/></td>
      </tr>

      <tr>
        <th scope = "row"><s:label value = "ふりがな"/></th>
        <td><s:property value = "userInfoDTO.familyNameKana"/><s:property value = "userInfoDTO.firstNameKana"/></td>
      </tr>

      <tr>
        <th scope = "row"><s:label value = "性別"/></th>
        <td><s:if test = "userInfoDTO.sex == 0">男性</s:if><s:if test = "userInfoDTO.sex == 1">女性</s:if></td>
      </tr>

      <tr>
        <th scope = "row"><s:label value = "メールアドレス"/></th>
        <td><s:property value = "userInfoDTO.email"/></td>
      </tr>

    </table>

    <s:submit value = "購入履歴"/>
  </s:form>
  </div>
  <s:include value="footer.jsp"/>


</body>
</html>
