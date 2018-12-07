package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.CartInfoDAO;
import com.internousdev.sunflower.dao.PurchaseHistoryInfoDAO;
import com.internousdev.sunflower.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String radioId;

	public String execute(){
		String result = "";
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartDTOList = new ArrayList<CartInfoDTO>();
		PurchaseHistoryInfoDAO PHInfoDao = new PurchaseHistoryInfoDAO();

//		/*ログインしている場合*/
//		if(session.containsKey("LoginId")){

			/*商品履歴情報テーブルに商品ごとの決済情報を登録する*/

			/*ログインユーザのカート情報をカート情報テーブルから取得*/
			cartDTOList = cartInfoDao.getCartInfoDTOList(String.valueOf(session.get("loginId")), String.valueOf(session.get("tempUserId"))); //デバック時にコメントアウト
//			cartDTOList = cartInfoDao.getCartInfoDTOList("guest",null); //デバック用
			/*カート情報がない場合の処理*/
			Iterator<CartInfoDTO> iterator = cartDTOList.iterator();
			if(!(iterator.hasNext())){
//				cartDTOList = null;
				/*エラー画面に遷移*/
				return ERROR;
			}

			int addCount = 0; //商品履歴情報テーブルに登録された数を格納する変数

			/*購入履歴情報テーブルに1件ずつ登録*/
			for(int i=0;i<cartDTOList.size();i++){
				addCount += PHInfoDao.regist(
						String.valueOf(session.get("loginId")),//ユーザID //デバック時にコメントアウト
//						String.valueOf("guest"),//ユーザID //デバック用
						cartDTOList.get(i).getProductId(),//商品ID
						cartDTOList.get(i).getProductCount(),//個数
						/*要修正*/
						cartDTOList.get(i).getPrice(),//金額
						Integer.parseInt(radioId)//宛先情報ID
						);
			}

			/*登録に失敗した場合(つまりエラー)*/
			if(addCount <= 0){
				/*エラー画面に遷移*/
				return ERROR;
			}

			/*ユーザに紐付いているDBのカート情報テーブルの情報を削除する*/

			int deleteCount = 0; //カート情報テーブルから削除された商品情報の数を格納する変数
			/*セッションに保存されているログインIDをもつ商品情報をカート情報テーブルから削除*/
			deleteCount = cartInfoDao.deleteAll(String.valueOf(session.get("loginId"))); //デバック時にコメントアウト
//			deleteCount = cartInfoDao.deleteAll("guest"); //デバック用

			/*削除に失敗した場合(つまりエラー)*/
			if(deleteCount <= 0){
				System.out.println("NG");
				/*エラー画面に遷移*/
				return ERROR;
			}

			/*カート内の情報を再取得*/
//			cartDTOList.clear();
//			cartDTOList = cartInfoDao.getCartInfoDTOList(String.valueOf(session.get("loginId")), String.valueOf(session.get("tempUserId")));
//			iterator = cartDTOList.iterator();
//			if(!(iterator.hasNext())){
//				System.out.println("NG");
				cartDTOList = null;
//			}
			/*セッションにログインユーザのカート情報を再格納*/
			session.put("cartDTOList", cartDTOList);

			/*カート内商品の合計金額を取得*/
//			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(String.valueOf(session.get("tempUserId")), String.valueOf(session.get("loginId"))))); //デバック時にコメントアウト
//			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(null, "guest"))); //デバック用
			/*セッションにログインユーザのカート内商品の合計金額を再格納*/
//			session.put("totalPrice", totalPrice);

			/*カートフラグを折る*/
			if(session.containsKey("cartFlg")){
				session.remove("cartFlg");
			}

			/*ホーム画面へ遷移するための戻り値*/
			result = SUCCESS;
//		}

		/*ログインしていない場合*/
//		else{
//			/*???画面に遷移するための戻り値*/
//			result = ERROR;
//		}

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
