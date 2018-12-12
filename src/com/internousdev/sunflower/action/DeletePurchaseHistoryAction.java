package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.PurchaseHistoryInfoDAO;
import com.internousdev.sunflower.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
	private ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
	private String message;

	public String execute() {
		//セッションタイムアウト
				if(session == null || session.isEmpty()){
					return "timeOut";
				}

		String result = ERROR;
		// 購入履歴の全消去、戻り値は更新件数
		int count = purchaseHistoryInfoDAO.allDelete(session.get("loginId").toString());
		// 更新できた場合
		if(count > 0) {
			result = SUCCESS;
			purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryInfo(session.get("loginId").toString());  // 消去後の商品購入履歴一覧を取得する
			setMessage("商品購入履歴情報はありません。");
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public PurchaseHistoryInfoDAO getPurchaseHistoryInfoDAO() {
		return purchaseHistoryInfoDAO;
	}
	public void setPurchaseHistoryInfoDAO(PurchaseHistoryInfoDAO purchaseHistoryInfoDAO) {
		this.purchaseHistoryInfoDAO = purchaseHistoryInfoDAO;
	}
	public ArrayList<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList() {
		return purchaseHistoryInfoDTOList;
	}
	public void setPurchaseHistoryInfoDTOList(ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList) {
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
