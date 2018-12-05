package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SettlementComplete extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String radioId;

	public String execute(){
		String result = "";
		CartInforDAO cartInfoDao = new CartInfoDAO();
		ArrayList<CarInfoDTO> cartList = new ArrayList<CartInfoDTO>();
		PurchaseHistoryInfoDAO PHInfoDao = new PurchaseHistoryInfoDAO();

		/*ログインしている場合*/
		if(session.containsKey("")){


			/*商品履歴情報テーブルに商品ごとの決済情報を登録する*/

			/*ログインユーザのカート情報をカート情報テーブルから取得*/
			cartList = cartInfoDao.xxx(session.get(""));
			/*カート情報がない場合の処理*/
			Iterator<CartInfoDTO> iterator = cartList.iterator();
			if(!(iterator.hasNext())){
				cartList = null;
			}
			int addCount = 0; //商品履歴情報テーブルに登録された数を格納する変数

			/*購入履歴情報テーブルに1件ずつ登録*/
			for(int i=0;i<cartList.size();i++){
				addCount += PHInfoDao.xxx(
						String.valueOf(session.get("")),//ユーザID
						cartList.get().get(),//商品ID
						cartList.get().get(),//個数
						cartList.get().get(),//金額
						radioId//宛先情報ID
						);
			}

			/*登録に失敗した場合(つまりエラー)*/
			if(addCount <= 0){
				/*エラー画面に遷移*/
				return "sippai";
			}

			/*ユーザに紐付いているDBのカート情報テーブルの情報を削除する*/

			int deleteCount = 0; //カート情報テーブルから削除された商品情報の数を格納する変数
			/*セッションに保存されているログインIDをもつ商品情報をカート情報テーブルから削除*/
			deleteCount = cartInfoDao.xxx(String.valueOf(session.get("")));

			/*削除に成功した場合*/
			if(deleteCount > 0){

			}

			/*削除に失敗した場合*/
			/*(つまりはエラー)*/
			else{
				/*エラー画面に遷移*/
				return "sippai";
			}

			/*ホーム画面へ遷移するための戻り値*/
			result = SUCCESS;
		}

		/*ログインしていない場合*/
		else{
			/*???*/
			result = ERROR;
		}

		return result;
	}
	/*以下セッター＆ゲッター*/

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getRadioId() {
		return radioId;
	}

	public void setRadioId(String radioId) {
		this.radioId = radioId;
	}


}
