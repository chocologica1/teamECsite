package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	//フィールド
	private Map<String,Object> session;

	//メソッド
	public String execute() {

		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		String result = ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		//sessionからログインIDとID保存情報を取得
		String loginId = String.valueOf(session.get("loginId"));
		boolean savedLoginId = Boolean.valueOf(String.valueOf(session.get("savedLoginId")));

		//DBのloginedを0(未ログイン)にする
		int count = userInfoDAO.logout(loginId);
		if(count > 0) {
			//session情報を全て削除
			session.clear();
			//savedLoginIdがtrueだったらログインIDを保持
			if (savedLoginId) {
				session.put("savedLoginId", savedLoginId);
				session.put("keepLoginId", loginId);
			}
			result = SUCCESS;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
