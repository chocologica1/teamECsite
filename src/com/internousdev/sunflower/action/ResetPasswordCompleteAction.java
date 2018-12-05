package com.internousdev.sunflower.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {

	public String execute() {
		String result = ERROR;

		UserInfoDAO userInfoDAO = new UserInfoDAO();


	}

}
