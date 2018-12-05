package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute(){
		if(!session.containsKey("logined")){
			String result = "login";
			return result;
		}
		session.put("loginIdErrorMessageList", "");
		session.put("passwordErrorMessageLIst", "");
		session.put("loginErrorMessage","");
		session.remove("settlementFlg");

		return SUCCESS;
	}

	public Map<String, Object> getSessin(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
