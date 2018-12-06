package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.PurchaseHistoryInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();

	public String execute() {
		String result = ERROR;

		int count = 0;
		String loginId = session.get("loginId").toString();
		count = purchaseHistoryInfoDAO.allDelete(loginId);

		if(count > 0) {
			result = SUCCESS;
		} else {
			result = ERROR;
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

}
