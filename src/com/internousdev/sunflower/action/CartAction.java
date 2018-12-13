package com.internousdev.sunflower.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.CartInfoDAO;
import com.internousdev.sunflower.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();
	private List<CartInfoDTO> cartInfoDTOList;
	private int totalPrice;

	/**
	 * 	カート情報及び合計金額を取得しcart.jspへ遷移します。
	 */

	public String execute(){
		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		//カート情報及び合計金額の取得
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(String.valueOf(session.get("loginId")),String.valueOf(session.get("tempUserId")));
		totalPrice = cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")), String.valueOf(session.get("tempUserId")));
		return SUCCESS;
	}

	//以下getter及びsetter

	public List<CartInfoDTO> getCartInfoDTOList(){
		return cartInfoDTOList;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
