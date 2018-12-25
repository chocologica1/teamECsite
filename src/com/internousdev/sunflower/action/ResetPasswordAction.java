package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware {
	public Map<String,Object>session;
	private String reFlg;

	public String execute() {
		//セッションタイムアウト
				if(session == null || session.isEmpty()){
					return "timeOut";
				}

		String result = ERROR;
		//エラーメッセージを全て消去する
		session.remove("userIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("incorrectErrorMessageList");
		session.remove("newPasswordErrorMessageList");
		session.remove("reConfirmationNewPasswordErrorMessageList");
		session.remove("newPasswordIncorrectErrorMessageList");

		if(reFlg == null){
			result = SUCCESS;
			return result;
		}

		if(reFlg.equals("1")) {
			session.put("savedUserId", false);
			result = SUCCESS;
			return result;
		} else if(reFlg.equals("2")) {
			session.put("savedUserId", true);
			result = SUCCESS;
			return result;
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
	public String getReFlg() {
		return reFlg;
	}
	public void setReFlg(String reFlg) {
		this.reFlg = reFlg;
	}

}
