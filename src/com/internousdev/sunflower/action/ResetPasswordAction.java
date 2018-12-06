package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware {
	public Map<String,Object>session;
	private String passFlg;

	public String execute() {
		String result = ERROR;

		//エラーメッセージを全て消去する
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("passwordIncorrectErrorMessageList");
		session.remove("newPasswordErrorMessageList");
		session.remove("reConfirmationNewPasswordErrorMessageList");
		session.remove("newPasswordIncorrectErrorMessageList");

		result = SUCCESS;

		return result;
	}




	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getPassFlg() {
		return passFlg;
	}
	public void setPassFlg(String passFlg) {
		this.passFlg = passFlg;
	}


}
