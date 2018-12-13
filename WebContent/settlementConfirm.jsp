<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/settlement.css">
<title>決済確認画面</title>
</head>
<body>

	<!-- ヘッダー -->
	<s:include value="header.jsp"/>

	<!-- コンテンツ -->
	<div id="contents">
		<h1>決済確認画面</h1>

			<!-- 宛先情報が存在する場合 -->
		<s:if test="#session.destinationInfoDTOList.size()>0">
				<div class="info">
					宛先を選択してください
				</div>
				<!-- 宛先選択フォーム -->
			<s:form action="SettlementCompleteAction">
					<!-- 宛先情報テーブル -->
				<table class="horizontal-list-table">
					<tr>
						<th>#</th>
						<th>姓</th>
						<th>名</th>
						<th>ふりがな</th>
						<th>住所</th>
						<th>電話番号</th>
						<th>メールアドレス</th>
					</tr>
					<!-- イテレータによるループ表記 -->
					<s:iterator value="#session.destinationInfoDTOList" status="st">
						<tr>
							<!-- 選択用ラジオボタン -->
							<td>
								<!-- 1行目の場合 -->
								<s:if test="#st.index==0">
									<!-- （宛先情報テーブルのIDカラムを保持） -->
									<input type="radio" name="radioId" checked="checked" value="<s:property value="id"/>"/>
								</s:if>
								<!-- 2行目以降 -->
								<s:else>
									<!-- （宛先情報テーブルのIDカラムを保持） -->
									<input type="radio" name="radioId" value="<s:property value="id"/>"/>
								</s:else>
							</td>
							<!-- 姓 -->
							<td><s:property value="familyName"/></td>
							<!-- 名 -->
							<td><s:property value="firstName"/></td>
							<!-- ふりがな -->
							<td><s:property value="familyNameKana"/><span>　</span><s:property value="firstNameKana"/></td>
							<!-- 住所 -->
							<td><s:property value="userAddress"/></td>
							<!-- 電話番号 -->
							<td><s:property value="telNumber"/></td>
							<!-- メールアドレス -->
							<td><s:property value="email"/></td>
						</tr>
					</s:iterator>
				</table>

				<!-- 決済ボタン -->
				<div class="submit_btn_box">
					<s:submit value="決済" class="submit_btn"/>
				</div>
			</s:form>
		</s:if>

		<!-- 宛先情報が存在しない場合 -->
		<s:else>
			<!-- メッセージを表示 -->
			<div class="info">
				宛先情報がありません。
			</div>
		</s:else>

		<!-- 新規宛先登録ボタン -->
		<s:form action="CreateDestinationAction">
			<input type="hidden" name="createDestinationFlg" value="true"/>
			<div class="submit_btn_box">
				<s:submit value="新規宛先登録" class="submit_btn"/>
			</div>
		</s:form>
	</div>

	<!-- フッター -->
	<s:include value="footer.jsp"/>

</body>
</html>
