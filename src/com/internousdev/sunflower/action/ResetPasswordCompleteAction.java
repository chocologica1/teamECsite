package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {
	private String userId;
	private String password;
	private Map<String,Object> session;

	public String execute() {
		//セッションタイムアウト
				if(session == null || session.isEmpty()){
					return "timeOut";
				}

		String result = ERROR;

		UserInfoDAO userInfoDAO = new UserInfoDAO();   //UserInfoDAOをインスタンス化
		//DB上の情報を更新、更新した件数
		int count = userInfoDAO.resetPassword(session.get("copyUserId").toString(), session.get("newPassword").toString());
		if(count > 0) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		return result;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
