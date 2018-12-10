<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="">
<title>決済確認画面</title>
</head>
<body>

	<!-- ヘッダー -->
	<s:include value="header.jsp"/>

	<!-- メイン -->
	<div id="main">

		<!-- コンテンツ -->
		<div id="contents">

			<!-- 宛先情報が存在する場合 -->
			<s:if test="#session.destinationInfoDTOList.size()>0">
				宛先を選択してください

				<!-- 宛先選択フォーム -->
				<s:form action="SettlementCompleteAction">

					<!-- 宛先情報テーブル -->
					<table>
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
					<s:submit value="決済"/>
				</s:form>
			</s:if>

			<!-- 宛先情報が存在しない場合 -->
			<s:else>
				<!-- メッセージを表示 -->
				<div id="message">
					宛先情報がありません。
				</div>
			</s:else>

			<!-- 新規宛先登録ボタン -->
			<s:form action="CreateDestinationAction">
				<s:submit value="新規宛先登録"/>
			</s:form>

			<s:form action="SettlementConfirmAction">
				<s:submit value="リダイレクト"/>
			</s:form>

		</div>
	</div>


	<!-- フッター -->
	<s:include value="footer.jsp"/>

</body>
</html>
