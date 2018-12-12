package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.PurchaseHistoryInfoDAO;
import com.internousdev.sunflower.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
	private ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
	private String message;

	public String execute() {
		//セッションタイムアウト
				if(session == null || session.isEmpty()){
					return "timeOut";
				}

		if(session.containsKey("loginId")) {
			// DBから商品購入履歴一覧を取得してリストに情報を格納する
			purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryInfo(session.get("loginId").toString());
		}
		setMessage("商品購入履歴情報はありません。");
		return SUCCESS;
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
