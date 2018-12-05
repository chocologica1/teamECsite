package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.CartInfoDAO;
import com.internousdev.sunflower.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private CommonUtility commonUtility = new CommonUtility();
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();

	/**
	 * productDetails.jsp（商品詳細画面）から受け取るパラメータ
	 * 	※※変数名は仮決定
	 */
	private int productId;
	private int productCount;

	/**
	 * CartInfoDAOのregistメソッドを呼び出しカート情報テーブルに商品を登録する。
	 * 成功した場合cart.jspへ遷移。
	 * 失敗した場合error.jspへ遷移。
	 */

	public String execute(){
		int result = 0;
		
		//未ログインかつ仮ユーザーIDを発行していない場合、仮ユーザーIDを発行しsessionに格納
		if(!(session.containsKey("userId") || session.containsKey("tempUserId"))){
			session.put("tempUserId", commonUtility.getRamdomValue());
		}
		
		/*
		 * registメソッドを呼び出し、カート情報テーブルに商品を追加する。
		 * 戻り値はresultに格納。成功した場合正の整数、失敗した場合0が戻る。
		 */
		result = cartInfoDAO.regist(productId,productCount,String.valueOf(session.get("userId")),String.valueOf(session.get("tempUserId")));
		
		//resultが1以上であればSUCCESS、0以下であればERRORを戻す。
		return result > 0 ? SUCCESS : ERROR;
	}

	//以下getter及びsetter

	public void setProductId(int productId){
		this.productId = productId;
	}

	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
